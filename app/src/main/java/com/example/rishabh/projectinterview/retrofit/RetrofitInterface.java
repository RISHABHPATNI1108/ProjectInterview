package com.example.rishabh.projectinterview.retrofit;

import com.example.rishabh.projectinterview.models.ChatResponseModel;
import com.example.rishabh.projectinterview.models.CodesModels;
import com.example.rishabh.projectinterview.models.QnAModel;
import com.example.rishabh.projectinterview.models.ThreadsResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {

    // API Call To get chats
    @GET("test_json/chat.json")
    Call<List<ChatResponseModel>> getChat();

    // API Call To get Threads
    @GET("test_json/threads.json")
    Call<List<ThreadsResponseModel>> getThreads();

    // API Call To get Questions
    @GET("test_json/threads.json")
    Call<List<QnAModel>> getQues();

//     API Calls to get Codes details
    @GET("test_json/codes.json")
    Call<List<CodesModels>> getCodes();

}
