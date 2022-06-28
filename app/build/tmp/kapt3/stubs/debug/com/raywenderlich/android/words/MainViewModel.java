package com.raywenderlich.android.words;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u001a\u001a\u00020\u001b2\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001dH\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\rJ\u0010\u0010\u0011\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010\tJ$\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0002J+\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0\u000f\"\u0004\b\u0000\u0010&*\b\u0012\u0004\u0012\u0002H&0\u000b2\u0006\u0010\'\u001a\u0002H&H\u0002\u00a2\u0006\u0002\u0010(R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R \u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u000f\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/raywenderlich/android/words/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_search", "", "allWords", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/raywenderlich/android/words/data/words/Word;", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "search", "getSearch", "searchWords", "wordRepository", "Lcom/raywenderlich/android/words/data/words/WordRepository;", "words", "getWords$annotations", "()V", "getWords", "effect", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "load", "saveComment", "word", "term", "stateInViewModel", "T", "initialValue", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _search = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> search = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> allWords = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> searchWords = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    private final com.raywenderlich.android.words.data.words.WordRepository wordRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> words = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearch() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> getWords() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated()
    public static void getWords$annotations() {
    }
    
    public final void load() {
    }
    
    private final void effect(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> block) {
    }
    
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>>> words(java.lang.String search) {
        return null;
    }
    
    private final <T extends java.lang.Object>kotlinx.coroutines.flow.StateFlow<T> stateInViewModel(kotlinx.coroutines.flow.Flow<? extends T> $this$stateInViewModel, T initialValue) {
        return null;
    }
    
    public final void search(@org.jetbrains.annotations.Nullable()
    java.lang.String term) {
    }
    
    public final void saveComment(@org.jetbrains.annotations.NotNull()
    com.raywenderlich.android.words.data.words.Word word) {
    }
}