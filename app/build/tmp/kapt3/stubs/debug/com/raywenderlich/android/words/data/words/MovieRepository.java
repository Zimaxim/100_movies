package com.raywenderlich.android.words.data.words;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\b*\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/raywenderlich/android/words/data/words/MovieRepository;", "", "database", "Lcom/raywenderlich/android/words/data/words/AppDatabaseM;", "(Lcom/raywenderlich/android/words/data/words/AppDatabaseM;)V", "movieSource", "Lcom/raywenderlich/android/words/data/words/remote/MovieSource;", "movieStore", "Lcom/raywenderlich/android/words/data/words/local/MovieStore;", "(Lcom/raywenderlich/android/words/data/words/remote/MovieSource;Lcom/raywenderlich/android/words/data/words/local/MovieStore;)V", "ensureIsNotEmpty", "(Lcom/raywenderlich/android/words/data/words/local/MovieStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MovieRepository {
    private final com.raywenderlich.android.words.data.words.remote.MovieSource movieSource = null;
    private final com.raywenderlich.android.words.data.words.local.MovieStore movieStore = null;
    
    public MovieRepository(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.remote.MovieSource movieSource, @org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.local.MovieStore movieStore) {
        super();
    }
    
    public MovieRepository(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.AppDatabaseM database) {
        super();
    }
    
    private final java.lang.Object ensureIsNotEmpty(com.raywenderlich.android.words.data.words.local.MovieStore $this$ensureIsNotEmpty, kotlin.coroutines.Continuation<? super com.raywenderlich.android.words.data.words.local.MovieStore> p1) {
        return null;
    }
}