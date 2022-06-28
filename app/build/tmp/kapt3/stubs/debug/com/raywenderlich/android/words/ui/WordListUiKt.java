package com.raywenderlich.android.words.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001aP\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0007\u001a0\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0003\u001a\f\u0010\u0011\u001a\u00020\u0001*\u00020\u0012H\u0003\u00a8\u0006\u0013"}, d2 = {"WordColumnItem", "", "word", "Lcom/raywenderlich/android/words/data/words/Word;", "onClick", "Lkotlin/Function0;", "WordListUi", "words", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "search", "", "onSearch", "Lkotlin/Function1;", "onSave", "WordsContent", "onSelected", "EmptyContent", "Landroidx/compose/foundation/lazy/LazyItemScope;", "app_debug"})
public final class WordListUiKt {
    
    @androidx.compose.runtime.Composable()
    public static final void WordListUi(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>> words, @org.jetbrains.annotations.Nullable()
    java.lang.String search, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearch, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.raywenderlich.android.words.data.words.Word, kotlin.Unit> onSave) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void EmptyContent(androidx.compose.foundation.lazy.LazyItemScope $this$EmptyContent) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void WordColumnItem(com.raywenderlich.android.words.data.words.Word word, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void WordsContent(kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.raywenderlich.android.words.data.words.Word>> words, kotlin.jvm.functions.Function1<? super com.raywenderlich.android.words.data.words.Word, kotlin.Unit> onSelected) {
    }
}