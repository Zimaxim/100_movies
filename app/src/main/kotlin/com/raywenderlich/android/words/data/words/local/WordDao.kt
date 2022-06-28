package com.raywenderlich.android.words.data.words.local

import androidx.paging.PagingSource
import androidx.room.*
import com.raywenderlich.android.words.data.words.Word

@Dao                                                 // 1
interface WordDao {
    @Query("select * from word where length(id) > 0   order by value")        // 2
    fun queryAll(): PagingSource<Int, LocalWord>
//    fun queryAll(): List<LocalWord>

    @Query("select * from word where length(id) > 0  and value like '%' || :term || '%' order by value")
    fun searchAll(term: String): PagingSource<Int, LocalWord>

//    @Query("select * from word where id = :term  ")
//    suspend fun searchWord(term: String): PagingSource<Int, LocalWord>


    @Insert(onConflict = OnConflictStrategy.REPLACE)   // 3
    suspend fun insert(words: List<LocalWord>)

    @Query("select count(*) from word where length(id) > 0 ")                // 4
    suspend fun count(): Long

//    @Query("update word set title = :note where id = :id ")                // 4
//    suspend fun saveComment( id: String, note: String  ): Int
    @Update
    suspend fun update(word: LocalWord): Int
}
