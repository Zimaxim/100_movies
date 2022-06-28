package com.raywenderlich.android.words.data.words.local

import androidx.paging.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raywenderlich.android.words.data.words.AppDatabaseM
import com.raywenderlich.android.words.data.words.Movies
import com.raywenderlich.android.words.data.words.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieStore(database: AppDatabaseM) {
    // 1

    private val movies = database.movies


    // 2
//    fun all(): List<Movie> = words.queryAll().map { it.fromLocal() }

//    fun all(): Flow<PagingData<Movie>> = pagingMovie { movies.queryAll() }

//    fun all(term: String): Flow<PagingData<Movie>> = pagingMovie { words.searchAll(term) }

    fun all(term: String): Flow<PagingData<Movie>> =
        pagingMovie { movies.searchAll(term) }

    // 3
    suspend fun save(movies: List<Movie>) {
        this.movies.insert(movies.map { it.toLocal() })

//        val typeToken = object : TypeToken<List<Movies>>() {}.type
//        var gson = Gson()
//        val json =
//            """[{"name":"John"},{"name":"Jane"},{"name":"William"}]"""
//        val typeToken = object : TypeToken<List<Author>>() {}.type
//        val authors = Gson().fromJson<List<Author>>(json, typeToken)
//




    }

    // 4
    suspend fun isEmpty(): Boolean = movies.count() == 0L
}

private fun Movie.toLocal() = LocalMovie(
    id = id,
    title = title,
)

private fun LocalMovie.fromLocal() = Movie(
    id = id,
    title = title,
)

private fun pagingMovie(
    block: () -> PagingSource<Int, LocalMovie>,
): Flow<PagingData<Movie>> =
    Pager(PagingConfig(pageSize = 20)) { block() }.flow
        .map { page -> page.map { localMovie -> localMovie.fromLocal() } }
