package com.example.wares;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class FragmentLogin extends Fragment {


    EditText etLogin, etPassword;
    Button btLogin;

    private final static String TAG = FragmentLogin.class.getSimpleName();

    private SQLiteDatabase database;
    private UserDbHelper databaseHelper;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etLogin = (EditText) view.findViewById(R.id.etLoginLog);
        etPassword = (EditText) view.findViewById(R.id.etPasswordLog);
        btLogin =  (Button) view.findViewById(R.id.buttonLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authentication();
            }
        });
        databaseHelper = new UserDbHelper(getActivity());
        database = databaseHelper.getReadableDatabase();



        return view;
    }

    private void authentication(){
        String login = etLogin.getText().toString();
        String password = etPassword.getText().toString();

        /*String[] projection = {
                User.UserData._ID,
                User.UserData.COLUMN_LOGIN,
                User.UserData.COLUMN_PASSWORD
        };

        String selection = User.UserData.COLUMN_NAME.trim() + " = ? ";
        String[] selectionArgs = {login};

        String sortOrder =  null;

        Cursor cursor = database.query(User.UserData.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);


        if( cursor != null && cursor.moveToNext() ){
            Log.i(TAG, "To sie wykonalo");
            ArrayList<String> str = new ArrayList<>();
            String[] columns = cursor.getColumnNames();
                for (String column : columns) {
                    Log.i(TAG, "To sie wykonalo");
                    str.add(cursor.getString(cursor.getColumnIndex(column)));
                }
            cursor.close();
                for(String arr : str){
                    Log.i(TAG, arr);
                }
        }*/

        Cursor c = database.rawQuery("SELECT " + User.UserData.COLUMN_PASSWORD + "," + User.UserData.COLUMN_LOGIN + " FROM " + User.UserData.TABLE_NAME, null);
        if (c.moveToFirst()){
            do {
                // Passing values
                String pass = c.getString(0);
                String log = c.getString(1);
                // Do something Here with values
                Log.i(TAG, pass + " \t " + log);
                if(login.equals(log) && password.equals(pass)){
                  Log.i(TAG, "OK");
                    Intent intent = new Intent(getActivity(), ChoiceActivity.class);
                    startActivity(intent);
                }
            } while(c.moveToNext());
        }
        Log.i(TAG, "Login: " + login + "  Password: " + password);
        c.close();
       // database.close();


    }


}
