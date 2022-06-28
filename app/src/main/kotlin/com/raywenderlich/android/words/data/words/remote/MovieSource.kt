package com.raywenderlich.android.words.data.words.remote

import AppHttpClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.raywenderlich.android.words.data.words.Movies
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class MovieSource(private val client: HttpClient = AppHttpClient) {                           // 2
    private val typeToken = object : TypeToken<List<Movies>>() {}.type
    private var gson = Gson()
    suspend fun load(): List<Movies> = withContext(Dispatchers.IO) {
         client.getRemoteMovies() // 3
            .lineSequence()       // 4
            .map{
                 Gson().fromJson<Movies>(it, Movies::class.java)
            }.toList()

    }
}

private suspend fun HttpClient.getRemoteMovies(): String =
    get("https://imdb-api.com/en/API/MostPopularMovies/k_7ffgs38v")
//    get("https://imdb-api.com/ru/API/Title/k_7ffgs38v/tt9419884")
//    get("https://pablisco.com/define/movies")

