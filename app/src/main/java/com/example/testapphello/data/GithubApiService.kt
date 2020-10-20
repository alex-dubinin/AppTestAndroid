package com.example.testapphello.data

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*


interface GithubApiService {

    @GET("search/users")
    fun search(@Query("q") query:String,
               @Query("page") page: Int,
               @Query("per_page") perPage: Int) :Observable


    companion object Factory{
//        fun interceptor(): OkHttpClient{
//            val original = Request()
//                    .header("")
//
//        }

        fun create(): GithubApiService{
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(GithubApiService::class.java)
        }
    }

}