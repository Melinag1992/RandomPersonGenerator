package com.example.c4q.exam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.c4q.exam.controller.ModelAdapter;
import com.example.c4q.exam.model.ListOfUsers;
import com.example.c4q.exam.model.Results;
import com.example.c4q.exam.network.UserAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Retrofit retrofit;
    List<Results> resultsList = new ArrayList<>();
    ModelAdapter modelAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        modelAdapter = new ModelAdapter(getApplicationContext());
        recyclerView.setAdapter(modelAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        setRetrofit();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        modelAdapter.notifyDataSetChanged();
        return super.onOptionsItemSelected(item);
    }


    private void setRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        UserAPI userAPIservice = retrofit.create(UserAPI.class);
        Call<ListOfUsers> response = userAPIservice.getUserResults();

        response.enqueue(new Callback<ListOfUsers>() {
            public static final String TAG = "You Failed because... ";

            @Override
            public void onResponse(Call<ListOfUsers> call, Response<ListOfUsers> response) {

                if(response.isSuccessful()) {
                    resultsList.clear();
                    resultsList = response.body().getResults();
                    modelAdapter.addImages(resultsList);


                }

            }

            @Override
            public void onFailure(Call<ListOfUsers> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t);

            }
        });
    }

}
