package com.raywenderlich.android.words.data.words

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.raywenderlich.android.words.data.words.local.LocalWord
import com.raywenderlich.android.words.data.words.local.WordDao
import io.ktor.http.*


@Database(
    version = 1,
    exportSchema = false,
    entities = [
        LocalWord::class,
    ]
)

abstract class AppDatabaseW : RoomDatabase() {

    companion object {

        private const val databaseName = "word"
        const val WORD_TABLE = "WORD_TABLE"


        @Volatile
        private var instance: AppDatabaseW? = null

        fun getInstance(context: Context): AppDatabaseW {
            synchronized(this) {
                return instance ?: instance ?: createDatabaseInstance(context)
            }
        }

        private fun migrationList() = arrayOf(
            object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("ALTER TABLE word  ADD COLUMN id TEXT NOT NULL DEFAULT ''")
                    database.execSQL("ALTER TABLE word  ADD COLUMN title TEXT NOT NULL DEFAULT ''")
                    database.execSQL("ALTER TABLE word  ADD COLUMN fullTitle TEXT NOT NULL DEFAULT ''")
                }
            },
        )

        private fun createDatabaseInstance(context: Context): AppDatabaseW {
            return Room
                .databaseBuilder(
                    context.applicationContext,
                    AppDatabaseW::class.java,
                    databaseName
                )
                .fallbackToDestructiveMigration()
                .build()
//                .addMigrations(*migrationList())
//                .allowMainThreadQueries()  // ++ TODO
//                .build()
        }
    }

    abstract fun getWords(): WordDao


}




/*

@Database(entities = [LocalWord::class], version = 2,exportSchema = false )
abstract class AppDatabase : RoomDatabase() {
    abstract fun getWords(): WordDao
//    abstract val movies: MovieDao

    companion object {
        private var INSTANCE: AppDatabase? = null



        fun getInstance(context: Context): AppDatabase? {

            val MIGRATION_1_2: Migration = object : Migration(1, 2) {
                override fun migrate(database: SupportSQLiteDatabase) {
                    // Since we didn't alter the table, there's nothing else to do here.
                    database.execSQL("ALTER TABLE word  ADD COLUMN id TEXT NOT NULL DEFAULT ''")
                    database.execSQL("ALTER TABLE word  ADD COLUMN title TEXT NOT NULL DEFAULT ''")
                    database.execSQL("ALTER TABLE word  ADD COLUMN fullTitle TEXT NOT NULL DEFAULT ''")

                }
            }


            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "words.db").allowMainThreadQueries()
                        .addMigrations(MIGRATION_1_2)
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }




//    words = Room.databaseBuilder(this, AppDatabase.class, "database")
//    .addMigrations(AppDatabase.MIGRATION_1_2)
//    .allowMainThreadQueries()
//    .build();
}

*/


//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE word  ADD COLUMN id TEXT NOT NULL DEFAULT ''")
//        database.execSQL("ALTER TABLE word  ADD COLUMN title TEXT NOT NULL DEFAULT ''")
//        database.execSQL("ALTER TABLE word  ADD COLUMN fullTitle TEXT NOT NULL DEFAULT ''")
//    }
//}
