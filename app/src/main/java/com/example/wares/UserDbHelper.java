package com.example.wares;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "users.db";
    private static final int DATABASE_VERSION = 1;

    private final static String TAG = UserDbHelper.class.getSimpleName();

    private final String SQL_CREATE_USER_TABLE
            = "CREATE TABLE " + User.UserData.TABLE_NAME
            + " (" + User.UserData._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + User.UserData.COLUMN_NAME + " TEXT NOT NULL, "
            + User.UserData.COLUMN_SURNAME + " TEXT NOT NULL, "
            + User.UserData.COLUMN_LOGIN + " TEXT, "
            + User.UserData.COLUMN_EMAIL + " TEXT, "
            + User.UserData.COLUMN_PASSWORD + " TEXT"
            + ");";


    public UserDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER_TABLE);
        Log.i(TAG, " onCreate smiga ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + User.UserData.TABLE_NAME);
        onCreate(db);
    }
}
