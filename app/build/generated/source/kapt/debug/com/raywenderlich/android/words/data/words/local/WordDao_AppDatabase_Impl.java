package com.raywenderlich.android.words.data.words.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_AppDatabase_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocalWord> __insertionAdapterOfLocalWord;

  private final EntityDeletionOrUpdateAdapter<LocalWord> __updateAdapterOfLocalWord;

  public WordDao_AppDatabase_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalWord = new EntityInsertionAdapter<LocalWord>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `word` (`value`,`id`,`title`,`fullTitle`,`note`,`isSelected`,`rank`,`year`,`imDbRating`,`releaseDate`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalWord value) {
        if (value.getValue() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getValue());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getFullTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullTitle());
        }
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.isSelected() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.isSelected());
        }
        if (value.getRank() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRank());
        }
        if (value.getYear() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getYear());
        }
        if (value.getImDbRating() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getImDbRating());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getReleaseDate());
        }
      }
    };
    this.__updateAdapterOfLocalWord = new EntityDeletionOrUpdateAdapter<LocalWord>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `word` SET `value` = ?,`id` = ?,`title` = ?,`fullTitle` = ?,`note` = ?,`isSelected` = ?,`rank` = ?,`year` = ?,`imDbRating` = ?,`releaseDate` = ? WHERE `value` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalWord value) {
        if (value.getValue() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getValue());
        }
        if (value.getId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
        if (value.getFullTitle() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullTitle());
        }
        if (value.getNote() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNote());
        }
        if (value.isSelected() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.isSelected());
        }
        if (value.getRank() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRank());
        }
        if (value.getYear() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getYear());
        }
        if (value.getImDbRating() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getImDbRating());
        }
        if (value.getReleaseDate() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getReleaseDate());
        }
        if (value.getValue() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getValue());
        }
      }
    };
  }

  @Override
  public Object insert(final List<LocalWord> words, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocalWord.insert(words);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object update(final LocalWord word, final Continuation<? super Integer> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        int _total = 0;
        __db.beginTransaction();
        try {
          _total +=__updateAdapterOfLocalWord.handle(word);
          __db.setTransactionSuccessful();
          return _total;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public PagingSource<Integer, LocalWord> queryAll() {
    final String _sql = "select * from word where length(id) > 0   order by value";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, LocalWord>() {
      @Override
      public LimitOffsetDataSource<LocalWord> create() {
        return new LimitOffsetDataSource<LocalWord>(__db, _statement, false, false , "word") {
          @Override
          protected List<LocalWord> convertRows(Cursor cursor) {
            final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(cursor, "value");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfFullTitle = CursorUtil.getColumnIndexOrThrow(cursor, "fullTitle");
            final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
            final int _cursorIndexOfIsSelected = CursorUtil.getColumnIndexOrThrow(cursor, "isSelected");
            final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(cursor, "rank");
            final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(cursor, "year");
            final int _cursorIndexOfImDbRating = CursorUtil.getColumnIndexOrThrow(cursor, "imDbRating");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final List<LocalWord> _res = new ArrayList<LocalWord>(cursor.getCount());
            while(cursor.moveToNext()) {
              final LocalWord _item;
              final String _tmpValue;
              if (cursor.isNull(_cursorIndexOfValue)) {
                _tmpValue = null;
              } else {
                _tmpValue = cursor.getString(_cursorIndexOfValue);
              }
              final String _tmpId;
              if (cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = cursor.getString(_cursorIndexOfId);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final String _tmpFullTitle;
              if (cursor.isNull(_cursorIndexOfFullTitle)) {
                _tmpFullTitle = null;
              } else {
                _tmpFullTitle = cursor.getString(_cursorIndexOfFullTitle);
              }
              final String _tmpNote;
              if (cursor.isNull(_cursorIndexOfNote)) {
                _tmpNote = null;
              } else {
                _tmpNote = cursor.getString(_cursorIndexOfNote);
              }
              final Integer _tmpIsSelected;
              if (cursor.isNull(_cursorIndexOfIsSelected)) {
                _tmpIsSelected = null;
              } else {
                _tmpIsSelected = cursor.getInt(_cursorIndexOfIsSelected);
              }
              final String _tmpRank;
              if (cursor.isNull(_cursorIndexOfRank)) {
                _tmpRank = null;
              } else {
                _tmpRank = cursor.getString(_cursorIndexOfRank);
              }
              final String _tmpYear;
              if (cursor.isNull(_cursorIndexOfYear)) {
                _tmpYear = null;
              } else {
                _tmpYear = cursor.getString(_cursorIndexOfYear);
              }
              final String _tmpImDbRating;
              if (cursor.isNull(_cursorIndexOfImDbRating)) {
                _tmpImDbRating = null;
              } else {
                _tmpImDbRating = cursor.getString(_cursorIndexOfImDbRating);
              }
              final String _tmpReleaseDate;
              if (cursor.isNull(_cursorIndexOfReleaseDate)) {
                _tmpReleaseDate = null;
              } else {
                _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              }
              _item = new LocalWord(_tmpValue,_tmpId,_tmpTitle,_tmpFullTitle,_tmpNote,_tmpIsSelected,_tmpRank,_tmpYear,_tmpImDbRating,_tmpReleaseDate);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    }.asPagingSourceFactory().invoke();
  }

  @Override
  public PagingSource<Integer, LocalWord> searchAll(final String term) {
    final String _sql = "select * from word where length(id) > 0  and value like '%' || ? || '%' order by value";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (term == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, term);
    }
    return new DataSource.Factory<Integer, LocalWord>() {
      @Override
      public LimitOffsetDataSource<LocalWord> create() {
        return new LimitOffsetDataSource<LocalWord>(__db, _statement, false, false , "word") {
          @Override
          protected List<LocalWord> convertRows(Cursor cursor) {
            final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(cursor, "value");
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfFullTitle = CursorUtil.getColumnIndexOrThrow(cursor, "fullTitle");
            final int _cursorIndexOfNote = CursorUtil.getColumnIndexOrThrow(cursor, "note");
            final int _cursorIndexOfIsSelected = CursorUtil.getColumnIndexOrThrow(cursor, "isSelected");
            final int _cursorIndexOfRank = CursorUtil.getColumnIndexOrThrow(cursor, "rank");
            final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(cursor, "year");
            final int _cursorIndexOfImDbRating = CursorUtil.getColumnIndexOrThrow(cursor, "imDbRating");
            final int _cursorIndexOfReleaseDate = CursorUtil.getColumnIndexOrThrow(cursor, "releaseDate");
            final List<LocalWord> _res = new ArrayList<LocalWord>(cursor.getCount());
            while(cursor.moveToNext()) {
              final LocalWord _item;
              final String _tmpValue;
              if (cursor.isNull(_cursorIndexOfValue)) {
                _tmpValue = null;
              } else {
                _tmpValue = cursor.getString(_cursorIndexOfValue);
              }
              final String _tmpId;
              if (cursor.isNull(_cursorIndexOfId)) {
                _tmpId = null;
              } else {
                _tmpId = cursor.getString(_cursorIndexOfId);
              }
              final String _tmpTitle;
              if (cursor.isNull(_cursorIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              }
              final String _tmpFullTitle;
              if (cursor.isNull(_cursorIndexOfFullTitle)) {
                _tmpFullTitle = null;
              } else {
                _tmpFullTitle = cursor.getString(_cursorIndexOfFullTitle);
              }
              final String _tmpNote;
              if (cursor.isNull(_cursorIndexOfNote)) {
                _tmpNote = null;
              } else {
                _tmpNote = cursor.getString(_cursorIndexOfNote);
              }
              final Integer _tmpIsSelected;
              if (cursor.isNull(_cursorIndexOfIsSelected)) {
                _tmpIsSelected = null;
              } else {
                _tmpIsSelected = cursor.getInt(_cursorIndexOfIsSelected);
              }
              final String _tmpRank;
              if (cursor.isNull(_cursorIndexOfRank)) {
                _tmpRank = null;
              } else {
                _tmpRank = cursor.getString(_cursorIndexOfRank);
              }
              final String _tmpYear;
              if (cursor.isNull(_cursorIndexOfYear)) {
                _tmpYear = null;
              } else {
                _tmpYear = cursor.getString(_cursorIndexOfYear);
              }
              final String _tmpImDbRating;
              if (cursor.isNull(_cursorIndexOfImDbRating)) {
                _tmpImDbRating = null;
              } else {
                _tmpImDbRating = cursor.getString(_cursorIndexOfImDbRating);
              }
              final String _tmpReleaseDate;
              if (cursor.isNull(_cursorIndexOfReleaseDate)) {
                _tmpReleaseDate = null;
              } else {
                _tmpReleaseDate = cursor.getString(_cursorIndexOfReleaseDate);
              }
              _item = new LocalWord(_tmpValue,_tmpId,_tmpTitle,_tmpFullTitle,_tmpNote,_tmpIsSelected,_tmpRank,_tmpYear,_tmpImDbRating,_tmpReleaseDate);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    }.asPagingSourceFactory().invoke();
  }

  @Override
  public Object count(final Continuation<? super Long> continuation) {
    final String _sql = "select count(*) from word where length(id) > 0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if(_cursor.moveToFirst()) {
            final Long _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
