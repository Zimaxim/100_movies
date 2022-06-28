package com.raywenderlich.android.words.data.words.remote

import AppHttpClient
import com.raywenderlich.android.words.data.words.Word
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class WordSource(private val client: HttpClient = AppHttpClient) {                           // 2

    suspend fun load(): List<Word> = withContext(Dispatchers.IO) {
         client.getRemoteWords() // 3
            .lineSequence()       // 4
            .map{ Word(value =  it) }
            .toList()

    }
}

private suspend fun HttpClient.getRemoteWords(): String =
    get("https://imdb-api.com/en/API/MostPopularMovies/k_7ffgs38v")
//    get("https://imdb-api.com/ru/API/Title/k_7ffgs38v/tt9419884")
//    get("https://pablisco.com/define/words")

