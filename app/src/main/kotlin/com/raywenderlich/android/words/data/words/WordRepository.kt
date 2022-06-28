package com.raywenderlich.android.words.data.words

import android.util.Log
import androidx.paging.PagingData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raywenderlich.android.words.data.words.local.WordStore
import com.raywenderlich.android.words.data.words.remote.MovieSource
import com.raywenderlich.android.words.data.words.remote.WordSource
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val wordSource: WordSource,
    // 1
    private val wordStore: WordStore,
) {

    // 2
    constructor(database: AppDatabase) : this(
        wordSource = WordSource(),
        wordStore = WordStore(database),

    )

    suspend fun allWords(): Flow<PagingData<Word>> =
        wordStore.ensureIsNotEmpty().all()

    suspend fun allWords(term: String): Flow<PagingData<Word>> =
        wordStore.ensureIsNotEmpty().all(term)


    suspend fun saveComment(word: Word){
        wordStore.saveComment(word)
    }

    private suspend fun WordStore.ensureIsNotEmpty() = apply {
        if (isEmpty()) {
            val movies = MovieSource().load()
//        Log.i("Movie", "LOAD ${movies[0].items[0].fullTitle}")
            val movie1 =  movies[0].items.toList()

            val words: List<Word> = movie1.map { Word(
                value= it.title,
                id  = it.id,
                title = it.title,
                fullTitle = it.fullTitle ?: "",
                note = "",
                isSelected = 0 ,
                rank = it.rank ?: "" ,
                year = it.year ?:"",
                imDbRating = it.imDbRating,
                releaseDate = it.releaseDate,

            ) };
            Log.i("Movie to Word", "LOAD ${words.size} records")
            save(words)
        }
    }
}

