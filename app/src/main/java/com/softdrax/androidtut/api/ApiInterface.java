package com.softdrax.androidtut.api;

import com.softdrax.androidtut.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Posts>> getPosts();

}
