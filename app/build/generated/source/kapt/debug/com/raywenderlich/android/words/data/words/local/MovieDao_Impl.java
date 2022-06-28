package com.raywenderlich.android.words.data.words.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
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
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LocalMovie> __insertionAdapterOfLocalMovie;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLocalMovie = new EntityInsertionAdapter<LocalMovie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `movie` (`id`,`title`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, LocalMovie value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
      }
    };
  }

  @Override
  public Object insert(final List<LocalMovie> movies,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLocalMovie.insert(movies);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public PagingSource<Integer, LocalMovie> queryAllMovie() {
    final String _sql = "select * from movie order by id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, LocalMovie>() {
      @Override
      public LimitOffsetDataSource<LocalMovie> create() {
        return new LimitOffsetDataSource<LocalMovie>(__db, _statement, false, false , "movie") {
          @Override
          protected List<LocalMovie> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final List<LocalMovie> _res = new ArrayList<LocalMovie>(cursor.getCount());
            while(cursor.moveToNext()) {
              final LocalMovie _item;
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
              _item = new LocalMovie(_tmpId,_tmpTitle);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    }.asPagingSourceFactory().invoke();
  }

  @Override
  public PagingSource<Integer, LocalMovie> searchAll(final String term) {
    final String _sql = "select * from movie where title like '%' || ? || '%' order by id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (term == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, term);
    }
    return new DataSource.Factory<Integer, LocalMovie>() {
      @Override
      public LimitOffsetDataSource<LocalMovie> create() {
        return new LimitOffsetDataSource<LocalMovie>(__db, _statement, false, false , "movie") {
          @Override
          protected List<LocalMovie> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final List<LocalMovie> _res = new ArrayList<LocalMovie>(cursor.getCount());
            while(cursor.moveToNext()) {
              final LocalMovie _item;
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
              _item = new LocalMovie(_tmpId,_tmpTitle);
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
    final String _sql = "select count(*) from movie";
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
