package com.example.rishabh.projectinterview.retrofit;


import android.support.annotation.NonNull;

import com.example.rishabh.projectinterview.Config;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient() {


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Config.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }
        return retrofit;
    }
}
