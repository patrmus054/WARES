package com.example.wares;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ChoiceActivity extends AppCompatActivity {

    Toolbar toolbar;
    private final static String TAG= ChoiceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_choice);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.menu_main);
        createMap();
    }

    private void createMap() {
        FragmentMaps maps = new FragmentMaps();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_container, maps, "Mapy").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "grrrr");
        String msg = "";

        switch(item.getItemId()){
            case R.id.showUsers:
                showUsers();
                break;
            case R.id.discard:
                msg = "Delete";
                break;
            case R.id.search:
                //showUsers();
                /*Intent intent = new Intent(this, ShowUsers.class);
                startActivity(intent);*/
                msg = "Search";
                break;
            case R.id.edit:
                msg = "Edit";
                break;
            case R.id.settings:
                msg = "Setting";
                break;
            case R.id.exit:
                msg="Exit";
                break;
        }
        Toast.makeText(ChoiceActivity.this, msg + " clicked", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }


    private void showUsers() {
        setContentView(R.layout.activity_show_users);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, User.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
       // recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    private void setUpRecyclerView(){
        //  RecyclerAdapter recyclerAdapter = (RecyclerAdapter) findViewById(R.id.recyclerView);
    }
}