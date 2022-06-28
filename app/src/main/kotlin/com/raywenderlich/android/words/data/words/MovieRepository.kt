package com.raywenderlich.android.words.data.words

import android.util.Log
import androidx.paging.PagingData
import com.google.gson.Gson
import com.raywenderlich.android.words.data.words.remote.MovieSource
import com.raywenderlich.android.words.data.words.local.MovieStore
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val movieSource: MovieSource,
    // 1
    private val movieStore: MovieStore,
) {


    // 2
    constructor(database: AppDatabaseM) : this(
        movieSource = MovieSource(),
        movieStore = MovieStore(database),
    )

    // 3
//    suspend fun allMovies(): List<Movie> =
//        movieStore.ensureIsNotEmpty().all()
//    suspend fun allMovies(): Flow<PagingData<Movie>> =
//        movieStore.ensureIsNotEmpty().all()





//    suspend fun allMovies(term: String): Flow<PagingData<Movie>> =
//        movieStore.ensureIsNotEmpty().all(term)



    private suspend fun MovieStore.ensureIsNotEmpty() = apply {
        Log.i("Movie","Step ensureIsNotEmpty")
        if (isEmpty()) {
            val movies: List<Movies> = movieSource.load()
            Log.i("Movie", movies.toString())

//            save(movies)
//            val json = movies[0].items
//
////            val movies = movieSource.load()
//            val movies =  Gson().fromJson<Movies>(json, Movies::class.java)
//            save( movies)
        }
    }




}







//class MovieRepository (
//    private val movieSource: MovieSource = MovieSource(),) {
//        suspend fun allMovies(): List<Movie> = movieSource.load()
//}