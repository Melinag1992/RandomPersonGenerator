package com.example.c4q.exam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.exam.model.Location;
import com.example.c4q.exam.model.Name;
import com.example.c4q.exam.model.Results;
import com.example.c4q.exam.model.Size;
import com.example.c4q.exam.model.User;
import com.example.c4q.exam.network.UserAPI;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlluserFragment extends Fragment {

    private View view;
    User[] userList;

    HashMap<String,String>nameHashMap;
    HashMap<String,String> locationHashMap;
    HashMap<String,String> sizeHashMap;



    public AlluserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_alluser, container, false);

        setRetrofit();

        return view ;

    }
    public void setRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        UserAPI userAPI = retrofit.create(UserAPI.class);
        Call<Results> getUserAPIresponse = userAPI.getUserResults();
        getUserAPIresponse.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {

                 userList = response.body().getResults();

                for (int i = 0; i < userList.length; i++) {

                    Log.d(TAG, "onResponse: " + userList[i]);
                }


//                Log.d(TAG, "onResponse: " + userList);
//
//                for (int i = 0; i <userList.size() ; i++) {
//                   nameHashMap.putAll( userList.get(i));
//                   locationHashMap.putAll(userList.get(i).getLocation());
//                   sizeHashMap.putAll(userList.get(i).getPicture());
//
//
//                }




            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);

            }
        });
    }

}
