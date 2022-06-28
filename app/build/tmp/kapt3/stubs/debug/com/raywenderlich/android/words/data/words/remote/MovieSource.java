package com.raywenderlich.android.words.data.words.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/raywenderlich/android/words/data/words/remote/MovieSource;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "gson", "Lcom/google/gson/Gson;", "typeToken", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "load", "", "Lcom/raywenderlich/android/words/data/words/Movies;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MovieSource {
    private final io.ktor.client.HttpClient client = null;
    private final java.lang.reflect.Type typeToken = null;
    private com.google.gson.Gson gson;
    
    public MovieSource() {
        super();
    }
    
    public MovieSource(@org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient client) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.raywenderlich.android.words.data.words.Movies>> continuation) {
        return null;
    }
}