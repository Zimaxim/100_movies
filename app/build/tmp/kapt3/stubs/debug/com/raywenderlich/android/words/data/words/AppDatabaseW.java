package com.raywenderlich.android.words.data.words;

import java.lang.System;

@androidx.room.Database(version = 1, exportSchema = false, entities = {com.raywenderlich.android.words.data.words.local.LocalWord.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/raywenderlich/android/words/data/words/AppDatabaseW;", "Landroidx/room/RoomDatabase;", "()V", "getWords", "Lcom/raywenderlich/android/words/data/words/local/WordDao;", "Companion", "app_debug"})
public abstract class AppDatabaseW extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.raywenderlich.android.words.data.words.AppDatabaseW.Companion Companion = null;
    private static final java.lang.String databaseName = "word";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORD_TABLE = "WORD_TABLE";
    @kotlin.jvm.Volatile()
    private static volatile com.raywenderlich.android.words.data.words.AppDatabaseW instance;
    
    public AppDatabaseW() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.raywenderlich.android.words.data.words.local.WordDao getWords();
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/raywenderlich/android/words/data/words/AppDatabaseW$Companion;", "", "()V", "WORD_TABLE", "", "databaseName", "instance", "Lcom/raywenderlich/android/words/data/words/AppDatabaseW;", "createDatabaseInstance", "context", "Landroid/content/Context;", "getInstance", "migrationList", "", "Landroidx/room/migration/Migration;", "()[Landroidx/room/migration/Migration;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.raywenderlich.android.words.data.words.AppDatabaseW getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final androidx.room.migration.Migration[] migrationList() {
            return null;
        }
        
        private final com.raywenderlich.android.words.data.words.AppDatabaseW createDatabaseInstance(android.content.Context context) {
            return null;
        }
    }
}