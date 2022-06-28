package com.raywenderlich.android.words.data.words.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")      // 1
data class LocalMovie(
    @PrimaryKey val id: String, // 2
    val title: String,

)