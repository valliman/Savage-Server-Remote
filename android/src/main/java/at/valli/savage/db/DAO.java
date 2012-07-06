package at.valli.savage.db;

/**
 * Created 27.03.12 - 11:49
 *
 * @author valli
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import at.valli.savage.domain.Server;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    private static final String DATABASE_NAME = "at.valli.savage.at.valli.savage.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE = "server";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_HOST = "host";
    public static final String KEY_PORT = "port";
    public static final String KEY_PASSWORD = "password";

    private static final String TAG = DAO.class.getName();

    private static final String DATABASE_CREATE =
            "create table " + TABLE + " ("
                    + KEY_ID + " integer primary key autoincrement, "
                    + KEY_NAME + " text not null, "
                    + KEY_HOST + " text not null, "
                    + KEY_PORT + " integer not null, "
                    + KEY_PASSWORD + " text);";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE);
            onCreate(db);
        }
    }

    private static DAO instance;

    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public static DAO getInstance() {
        if (instance == null) {
            instance = new DAO();
        }

        return instance;
    }

    public void open(Context ctx) {
        helper = new DatabaseHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public long create(Server server) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, server.getName());
        values.put(KEY_HOST, server.getHost());
        values.put(KEY_PORT, server.getPort());
        values.put(KEY_PASSWORD, server.getPassword());

        return db.insert(TABLE, null, values);
    }

    public boolean delete(String id) {
        return db.delete(TABLE, KEY_ID + "=?", new String[]{id}) > 0;
    }

    public Cursor fetch() {
        return db.query(TABLE, new String[]{KEY_ID, KEY_NAME, KEY_HOST, KEY_PORT, KEY_PASSWORD}, null, null, null, null, null);
    }

    public boolean update(Server server) {
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, server.getName());
        values.put(KEY_HOST, server.getHost());
        values.put(KEY_PORT, server.getPort());
        values.put(KEY_PASSWORD, server.getPassword());

        return db.update(TABLE, values, KEY_ID + "=?", new String[]{String.valueOf(server.getId())}) > 0;
    }
}
