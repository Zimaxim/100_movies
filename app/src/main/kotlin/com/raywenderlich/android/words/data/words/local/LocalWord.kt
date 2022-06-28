package com.raywenderlich.android.words.data.words.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.raywenderlich.android.words.data.words.Movie

@Entity(tableName = "word")      // 1
data class LocalWord(
    @PrimaryKey val value: String, // 2
    val id :String = "",
    var title: String = "",
    val fullTitle: String = "",

    /* ADDED for Version 3*/
//    @ColumnInfo(defaultValue = "")
    var note: String? = null,
    var isSelected: Int? = 0,
    val rank: String? = null ,
    val year: String? = null,
    val imDbRating: String? = null ,
    val releaseDate: String? = null,
    )

