package com.example.wares;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FragmentRegistration extends Fragment {

    EditText etName, etSurname, etLogin, etEmail, etPasswordOne, etPasswordTwo;
    Button register;

    FragmentManager manager;

    private SQLiteDatabase database;
    private UserDbHelper databaseHelper;

    private final static String TAG = FragmentRegistration.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = getFragmentManager();
        databaseHelper = new UserDbHelper(getActivity());
        database = databaseHelper.getWritableDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false );

        etName = (EditText) view.findViewById(R.id.etNameRegFrag);
        etSurname = (EditText) view.findViewById(R.id.etSurnameRegFrag);
        etLogin = (EditText) view.findViewById(R.id.etLoginRegFrag);
        etEmail = (EditText) view.findViewById(R.id.etEmailRegFrag);
        etPasswordOne = (EditText) view.findViewById(R.id.etPasswordRegFrag);
        etPasswordTwo = (EditText) view.findViewById(R.id.etRePasswordRegFrag);
        register = (Button) view.findViewById(R.id.buttonRegisterRegFrag);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String login = etLogin.getText().toString();
                String email = etEmail.getText().toString();
                String passwordOne = etPasswordOne.getText().toString();
                String passwordTwo = etPasswordTwo.getText().toString();
                Log.i(TAG, "onCreate: elo " + name);

                ContentValues contentValues = new ContentValues();
                contentValues.put(User.UserData.COLUMN_NAME, name);
                contentValues.put(User.UserData.COLUMN_SURNAME, surname);
                contentValues.put(User.UserData.COLUMN_LOGIN, login);
                contentValues.put(User.UserData.COLUMN_EMAIL, email);
                contentValues.put(User.UserData.COLUMN_PASSWORD, passwordOne);

                long rowId = database.insert(User.UserData.TABLE_NAME, null, contentValues);
                Log.i(TAG, "Items inserted in table with row id: " + rowId);

            }
        });


        return view;
    }

/*
    public void hideLoginFragment(){
        FragmentLogin fragmentLogin = (FragmentLogin)manager.findFragmentByTag("FragLogin");
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(fragmentLogin != null){
            fragmentTransaction.hide(fragmentLogin);
            fragmentTransaction.commit();
            showRegisterFragment();
        }else{
            Toast.makeText(this,"action can not be executed", Toast.LENGTH_SHORT).show();
        }

    }

    public void hideRegisterFragment(){
        FragmentRegistration fragmentRegistration = (FragmentRegistration) manager.findFragmentByTag("FragRegister");
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(fragmentRegistration != null){
            fragmentTransaction.hide(fragmentRegistration);
            fragmentTransaction.commit();
            showLoginFragment();
        }else{
            Toast.makeText(this,"action can not be executed", Toast.LENGTH_SHORT).show();
        }
    }

    private void showLoginFragment() {
        FragmentLogin fragmentLogin = (FragmentLogin)manager.findFragmentByTag("FragLogin");
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(fragmentLogin != null){
            fragmentTransaction.show(fragmentLogin);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this,"action can not be executed", Toast.LENGTH_SHORT).show();
        }
    }

    private void showRegisterFragment() {
        FragmentRegistration fragmentRegistration = (FragmentRegistration) manager.findFragmentByTag("FragRegister");
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if(fragmentRegistration != null){
            fragmentTransaction.show(fragmentRegistration);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this,"action can not be executed", Toast.LENGTH_SHORT).show();
        }
    }*/

}
