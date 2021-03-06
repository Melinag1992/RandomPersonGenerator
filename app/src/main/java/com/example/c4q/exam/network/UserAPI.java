package com.example.c4q.exam.network;

import com.example.c4q.exam.model.ListOfUsers;
import com.example.c4q.exam.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by c4q on 1/24/18.
 */

public interface UserAPI {
    @GET("?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<ListOfUsers> getUserResults();
}
