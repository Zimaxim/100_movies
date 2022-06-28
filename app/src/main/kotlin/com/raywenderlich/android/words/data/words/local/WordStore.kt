package com.raywenderlich.android.words.data.words.local

import android.util.Log
import androidx.lifecycle.Transformations.map
import androidx.paging.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raywenderlich.android.words.data.words.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WordStore(database: AppDatabase) {
    // 1
//    private val words = database.getWords()
    private val words = database.words
//    private val movies = database.movies

    // 2
//    fun all(): List<Word> = words.queryAll().map { it.fromLocal() }

    fun all(): Flow<PagingData<Word>> = pagingWord { words.queryAll() }

//    fun all(term: String): Flow<PagingData<Word>> = pagingWord { words.searchAll(term) }

    fun all(term: String): Flow<PagingData<Word>> =
        pagingWord { words.searchAll(term) }

    // 3
    suspend fun save(words: List<Word>) {
        Log.i("Movie_save"," 1 size =  ${words.size}")
        this.words.insert(words.map { it.toLocal() })
        Log.i("Movie_save"," 2 size =  ${words.size}")
    }

//        val typeToken = object : TypeToken<List<Movies>>() {}.type
//        var gson = Gson()
//        val json =
//            """[{"name":"John"},{"name":"Jane"},{"name":"William"}]"""
//        val typeToken = object : TypeToken<List<Author>>() {}.type
//        val authors = Gson().fromJson<List<Author>>(json, typeToken)
//

    suspend fun printMovies(movies: List<Movies>) {
        val transform: (Movies) -> List <Movie> = {it.items.toList()}
        movies.map{transform}.forEach { Log.i("Movie","${it.toString()}")}
    }



//    suspend fun saveMovies(movies: List<Movies>) {
//        val transform: (Movies) -> List <LocalMovie> = {it.items.map{it.toLocal()}}
//        this.movies.insert(movies.map { transform} )
//    }
    suspend fun isEmpty(): Boolean = words.count() == 0L

//    suspend fun isEmptyMovie(): Boolean = movies.count() == 0L
    suspend fun saveComment(word: Word): Int
    {


//        val cnt = words.saveComment(word, value)
        val cnt = words.update(word.toLocal())
        Log.i("MovieSave","id = ${word.id}, result = $cnt ")
        return  cnt
    }


}


private fun Word.toLocal() = LocalWord(
    value = value,
    id = id,
    title = title,
    fullTitle = fullTitle,
    note = note,
    isSelected = isSelected,
    rank = rank ,
    year = year,
    imDbRating = imDbRating,
    releaseDate = releaseDate,
)

private fun LocalWord.fromLocal() = Word(
    value = value,
    id = id,
    title = title,
    fullTitle = fullTitle,
    note = note,
    isSelected = isSelected,
    rank = rank ,
    year = year,
    imDbRating = imDbRating,
    releaseDate = releaseDate,
)

private fun Movie.toLocal() = LocalMovie(
    id = id,
    title = title,
)

//private fun LocalMovie.fromLocal() = Movie(
//    id = id,
//    title = title,
//)


private fun pagingWord(
    block: () -> PagingSource<Int, LocalWord>,
): Flow<PagingData<Word>> =
    Pager(PagingConfig(pageSize = 20)) { block() }.flow
        .map { page -> page.map { localWord -> localWord.fromLocal() } }
