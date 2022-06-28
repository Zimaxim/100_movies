package com.raywenderlich.android.words.data.words.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raywenderlich.android.words.data.words.Movie

@Dao                                                 // 1
interface MovieDao {
    @Query("select * from movie order by id")        // 2
    fun queryAllMovie(): PagingSource<Int, LocalMovie>


    @Query("select * from movie where title like '%' || :term || '%' order by id")
    fun searchAll(term: String): PagingSource<Int, LocalMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)   // 3
    suspend fun insert(movies: List<LocalMovie>)

    @Query("select count(*) from movie")                // 4
    suspend fun count(): Long
}