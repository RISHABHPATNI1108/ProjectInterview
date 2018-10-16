package com.example.rishabh.projectinterview.retrofit;

import com.example.rishabh.projectinterview.models.ChatResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    @GET("test_json/chat.json")
    Call<List<ChatResponseModel>> getChat();

}
