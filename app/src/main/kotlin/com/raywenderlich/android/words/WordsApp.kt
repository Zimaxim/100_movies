/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.words


import android.app.Application
import android.database.sqlite.SQLiteException
import android.util.Log
import androidx.room.Room
import androidx.room.RoomMasterTable.TABLE_NAME
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.raywenderlich.android.words.data.words.AppDatabase
import com.raywenderlich.android.words.data.words.WordRepository


class WordsApp : Application() {
//    val wordRepository by lazy { WordRepository() }
private val database by lazy {

     fun migrationList() = arrayOf(
        object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE word  ADD COLUMN id TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE word  ADD COLUMN title TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE word  ADD COLUMN fullTitle TEXT NOT NULL DEFAULT ''")
                database.execSQL("ALTER TABLE word  ADD COLUMN note  TEXT ")
                database.execSQL("ALTER TABLE word  ADD COLUMN isSelected INTEGER  ")
//                database.execSQL("ALTER TABLE word  ADD COLUMN rank TEXT  ")
//                database.execSQL("ALTER TABLE word  ADD COLUMN year TEXT  ")
//                database.execSQL("ALTER TABLE word  ADD COLUMN imDbRating TEXT  ")
//                database.execSQL("ALTER TABLE word  ADD COLUMN releaseDate TEXT ")


            }
        },

    object : Migration(2, 3) {
             override fun migrate(database: SupportSQLiteDatabase) {
                 try {

                     database.execSQL(
                         "CREATE TABLE word_new (value TEXT NOT NULL DEFAULT '',"+
                                 " id TEXT  NOT NULL DEFAULT ''," +
                                 " title TEXT  NOT NULL DEFAULT ''," +
                                 " fulltitle TEXT  NOT NULL DEFAULT ''," +
                                 " note TEXT ," +
                                 " isSelected INTEGER,"+
                                 " rank TEXT  ," +
                                 " year TEXT  ," +
                                 " imdbrating TEXT  ," +
                                 " releasedate TEXT  ," +
                                 " PRIMARY KEY(value))");
// Copy the data
                     database.execSQL(
                         "INSERT INTO word_new (value, id, title, fulltitle,note, isselected  ) "+
                                 " SELECT value, id, title, fulltitle,note, isselected "+
                                 "FROM word where length(id) > 0 ");
// Remove the old table
                     database.execSQL("DROP TABLE word");
// Change the table name to the correct one
                     database.execSQL("ALTER TABLE word_new RENAME TO word");


                 } catch (ex: SQLiteException) {
                     Log.w("Migration_Database", "Altering word: " + ex.message)
                 }
//                 database.execSQL("ALTER TABLE word  ADD COLUMN releaseDate TEXT  DEFAULT ''")
//                 database.execSQL("DELETE FROM word  WHERE length(id) = 0  ")
//                 database.execSQL("COMMIT  ")
             }
         },
    )

    Room.databaseBuilder(this, AppDatabase::class.java,
        "database.db")
        .addMigrations(*migrationList())
        .allowMainThreadQueries()  // ++ TODO
        .build()
//        .fallbackToDestructiveMigration()


}

    val wordRepository by lazy { WordRepository(database) }


}