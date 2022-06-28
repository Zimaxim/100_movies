package com.raywenderlich.android.words.data.words

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//class Movies
@Serializable
data class Movies(
    @SerialName("page")
    val page: Int = 0,
    @SerialName("items")
    val items: List<Movie> = ArrayList()
)

@Serializable
data class Item(
    @SerialName("item")
    val item: Movie
)

// https://imdb-api.com/ru/API/Title/k_7ffgs38v/tt9419884
//class Movie
@Serializable
data class Movie(
    @SerialName("id")
    var id: String,
    @SerialName("rank")
    val rank: String? = null,
    @SerialName("rankUpDown")
    val rankUpDown: String? = null,
    @SerialName("title")
    val title: String,
    @SerialName("fullTitle")
    val fullTitle: String? = null,
    @SerialName("year")
    val year: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("crew")
    val crew: String? = null,
    @SerialName("imDbRating")
    val imDbRating: String? = null,
    @SerialName("imDbRatingCount")
    val imDbRatingCount: String? = null,
    @SerialName("plot")
    val plot: String? = null,
    @SerialName("plotLocal")
    val plotLocal: String? = null,
    @SerialName("releaseDate")
    val releaseDate: String? = null,
)
