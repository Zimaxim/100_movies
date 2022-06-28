package com.raywenderlich.android.words.data.words

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.words.data.words.local.LocalMovie
import com.raywenderlich.android.words.data.words.local.MovieDao



@Database(entities = [LocalMovie::class], version = 1)
abstract class AppDatabaseM : RoomDatabase() {
    abstract val movies: MovieDao
}
