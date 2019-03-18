package com.example.wares;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ChoiceActivity extends AppCompatActivity {

    Toolbar toolbar;
    private boolean mLocationPermissionGrated = false;
    @Override
    protected void onCreate(Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_choice);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,  menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";

        switch(item.getItemId()){
            case R.id.discard:
                msg = "Delete";
                break;
            case R.id.search:
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
        Toast.makeText(this, msg + " clicked", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    private void setUpRecyclerView(){
      //  RecyclerAdapter recyclerAdapter = (RecyclerAdapter) findViewById(R.id.recyclerView);
    }
}
