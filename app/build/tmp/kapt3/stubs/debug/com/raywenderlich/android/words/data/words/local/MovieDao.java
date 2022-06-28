package com.raywenderlich.android.words.data.words.local;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\'J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/raywenderlich/android/words/data/words/local/MovieDao;", "", "count", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "movies", "", "Lcom/raywenderlich/android/words/data/words/local/LocalMovie;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryAllMovie", "Landroidx/paging/PagingSource;", "", "searchAll", "term", "", "app_debug"})
public abstract interface MovieDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from movie order by id")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.raywenderlich.android.words.data.words.local.LocalMovie> queryAllMovie();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from movie where title like \'%\' || :term || \'%\' order by id")
    public abstract androidx.paging.PagingSource<java.lang.Integer, com.raywenderlich.android.words.data.words.local.LocalMovie> searchAll(@org.jetbrains.annotations.NotNull()
    java.lang.String term);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.raywenderlich.android.words.data.words.local.LocalMovie> movies, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "select count(*) from movie")
    public abstract java.lang.Object count(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
}