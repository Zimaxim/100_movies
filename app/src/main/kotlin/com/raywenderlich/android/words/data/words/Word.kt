package com.raywenderlich.android.words.data.words


import kotlinx.serialization.SerialName


data class Word(val value: String = "",
                val id :String = "",
                var title: String = "",
                val fullTitle: String = "",
                var note: String? = null ,
                var isSelected: Int? = null,
                val rank: String? = null,
                val year: String? = null,
                val imDbRating: String? = null ,
                val releaseDate: String? = null,



)

data class Article(
    var title: String,
    var category: String,
    var views: Int
) {
}
data class Author(
    var name: String,
    var type: String? = null,
    var articles: List<Article>? = null
) {
}
