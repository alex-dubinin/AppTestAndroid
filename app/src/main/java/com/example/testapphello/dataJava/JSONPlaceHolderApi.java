package com.example.testapphello.dataJava;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<User> getPostWithID(@Path("id") int id);

    @GET("/posts")
    public Call<List<User>> getAllPosts();

    @GET("/posts")
    public Call<List<User>> getPostOfUser(@Query("userId") int id);

    @POST("/posts")
    public Call<List<User>> postData(@Body User data);

}
