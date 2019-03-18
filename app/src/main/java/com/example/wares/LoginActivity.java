package com.example.wares;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{


    Button buttonRegister, buttonLogin;
    EditText etNameReg, etSurnameReg, etLoginReg, etEmailReg, etPasswordReg, etRetypePasswordReg;
    TextView AlreadyHaveAnAccount;
    Toolbar toolbar;

    private static final String TAG = LoginActivity.class.getSimpleName();
    FragmentManager manager;

    private SQLiteDatabase database;
    private UserDbHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        manager = getFragmentManager();
        createFragments();

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        /*buttonRegister = (Button) findViewById(R.id.buttonRegisterRegFrag);


        etNameReg = (EditText) findViewById(R.id.etNameRegFrag);
        etSurnameReg = (EditText) findViewById(R.id.etSurnameRegFrag);
        etLoginReg = (EditText) findViewById(R.id.etLoginRegFrag);
        etEmailReg = (EditText) findViewById(R.id.etEmailRegFrag);
        etPasswordReg = (EditText)findViewById(R.id.etPasswordRegFrag);
        etRetypePasswordReg = (EditText)findViewById(R.id.etPasswordRegFrag);*/

        AlreadyHaveAnAccount = (TextView)findViewById(R.id.tvAlreadyHaveAnAccount);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

          databaseHelper = new UserDbHelper(this);
          database = databaseHelper.getWritableDatabase();

        setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("WEARS");
    }

    private void createFragments(){
        FragmentRegistration fragmentRegistration = new FragmentRegistration();
        FragmentLogin fragmentLogin = new FragmentLogin();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragmentRegistration, "FragRegister");
        transaction.add(R.id.container, fragmentLogin, "FragLogin");
        transaction.commit();
    }

    public void replaceByRegFrag(View view){
        Toast.makeText(LoginActivity.this, "dzialaj ", Toast.LENGTH_LONG).show();
        FragmentRegistration registration = new FragmentRegistration();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, registration, "fragReg");
        transaction.commit();

    }
    public void replaceByLogFrag(View view){
        FragmentLogin login = new FragmentLogin();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, login, "fragLog");
        transaction.commit();

    }



    /* public void authorisation(View view){
        Intent intent = new Intent(LoginActivity.this, ChoiceActivity.class);
        startActivity(intent);
    }*/
    /*public boolean performRegistration(View view){





    /*    checkDataInDatabase(login, email);

        ContentValues contentValues = new ContentValues();
        contentValues.put(User.UserData.COLUMN_NAME, name);
        contentValues.put(User.UserData.COLUMN_SURNAME, surname);
        contentValues.put(User.UserData.COLUMN_LOGIN, login);
        contentValues.put(User.UserData.COLUMN_EMAIL, email);
        contentValues.put(User.UserData.COLUMN_PASSWORD, passwordOne);

        long rowId = database.insert(User.UserData.TABLE_NAME, null, contentValues);
        Log.i(TAG, "Items inserted in table with row id: " + rowId);




        return true;

   }

    public boolean checkDataInDatabase(String login, String email){
        return true;
    }

    public void registration(View view) {
        Toast.makeText(this, "jestem tu ", Toast.LENGTH_LONG).show();

        String name = etNameReg.getText().toString();
//        String surname = etSurnameReg.getText().toString();
  //      String login = etLoginReg.getText().toString();
//        String email = etEmailReg.getText().toString();
//        String passwordOne = etPasswordReg.getText().toString();
//        String passwordTwo = etRetypePasswordReg.getText().toString();
*//*
        if(passwordOne != passwordTwo){ Toast.makeText(LoginActivity.this, "Passwords must match!", Toast.LENGTH_SHORT).show(); }
        else if(name == null || surname == null){ Toast.makeText(this,"field name and surname can not be blank ", Toast.LENGTH_SHORT).show(); }
        else{
            Toast.makeText(LoginActivity.this, "To smiga ", Toast.LENGTH_LONG).show();
        }*//*


    }*/
}
