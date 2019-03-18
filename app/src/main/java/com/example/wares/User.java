package com.example.wares;

import android.provider.BaseColumns;

public final class User {
    public static final class UserData implements BaseColumns {
        public static final String TABLE_NAME = "Users";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
    }
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


}
