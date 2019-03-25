package com.example.wares;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

import static com.example.wares.User.UserData.COLUMN_NAME;
import static com.example.wares.User.UserData.COLUMN_SURNAME;
import static com.example.wares.User.UserData.TABLE_NAME;
import static com.example.wares.User.UserData._ID;

public class User {
    public static final class UserData implements BaseColumns {
        public static final String TABLE_NAME = "Users";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
    }
    private final static String TAG = User.class.getSimpleName();

    private int imageID;
    private String name;
    private String surname;
    private String role;

    public void setName(String name) { this.name = name; }
    public void setImageID(int imageID) { this.imageID = imageID; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setRole(String role) { this.role = role; }

    public int getImageID() { return imageID; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getRole() { return role; }

    public static ArrayList<User> getData(){
        ArrayList<User> dataList = new ArrayList<>();
        SQLiteDatabase database;

        String DB_PATH = "/data/data/com.example.wares/databases/";
        String DB_NAME = "users.db";
        database = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME,null, SQLiteDatabase.CREATE_IF_NECESSARY);

        String[] projection = {
                _ID, COLUMN_NAME, COLUMN_SURNAME
        };

        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        if(cursor != null){
            while(cursor.moveToNext()){
                User user = new User();
                String[] columns = cursor.getColumnNames();
                int i = 0;
                for(String column : columns ){
                    Log.d(TAG, column);
                    if(i == 0)
                        user.setName(cursor.getString(cursor.getColumnIndex(column)));
                    if(i == 1)
                        user.setRole(cursor.getString(cursor.getColumnIndex(column)));
                    i++;
                }
                dataList.add(user);
            }
            cursor.close();
        }

        return dataList;
    }

}
