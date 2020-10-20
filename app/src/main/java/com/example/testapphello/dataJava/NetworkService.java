package com.example.testapphello.dataJava;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private Retrofit retrofit;

    private NetworkService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance(){
        if (networkService == null){
            networkService = new NetworkService();
        }
        return networkService;
    }

    public JSONPlaceHolderApi getJSONApi(){
        return retrofit.create(JSONPlaceHolderApi.class);
    }
}
