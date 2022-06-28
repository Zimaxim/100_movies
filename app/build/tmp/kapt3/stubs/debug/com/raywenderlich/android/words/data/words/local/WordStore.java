package com.raywenderlich.android.words.data.words.local;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0011\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00112\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/raywenderlich/android/words/data/words/local/WordStore;", "", "database", "Lcom/raywenderlich/android/words/data/words/AppDatabase;", "(Lcom/raywenderlich/android/words/data/words/AppDatabase;)V", "words", "Lcom/raywenderlich/android/words/data/words/local/WordDao;", "all", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/raywenderlich/android/words/data/words/Word;", "term", "", "isEmpty", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "printMovies", "", "movies", "", "Lcom/raywenderlich/android/words/data/words/Movies;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "save", "saveComment", "", "word", "(Lcom/raywenderlich/android/words/data/words/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WordStore {
    private final com.raywenderlich.android.words.data.words.local.WordDao words = null;
    
    public WordStore(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.AppDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>> all() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>> all(@org.jetbrains.annotations.NotNull()
    java.lang.String term) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object save(@org.jetbrains.annotations.NotNull()
    java.util.List<com.raywenderlich.android.words.data.words.Word> words, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object printMovies(@org.jetbrains.annotations.NotNull()
    java.util.List<com.raywenderlich.android.words.data.words.Movies> movies, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isEmpty(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveComment(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.Word word, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> continuation) {
        return null;
    }
}