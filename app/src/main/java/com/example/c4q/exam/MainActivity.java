package com.example.c4q.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlluserFragment alluserFragment = new AlluserFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_container,alluserFragment)
                .addToBackStack("allUser")
                .commit();

        alluserFragment.setRetrofit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.options:
                return true;
            case R.id.info:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
