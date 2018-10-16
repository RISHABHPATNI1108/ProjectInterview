package com.example.rishabh.projectinterview.fragments;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.adapters.MessageRecyclerAdapter;
import com.example.rishabh.projectinterview.adapters.ThreadsRecyclerAdapter;
import com.example.rishabh.projectinterview.models.ChatResponseModel;
import com.example.rishabh.projectinterview.models.ThreadsResponseModel;
import com.example.rishabh.projectinterview.retrofit.ApiClient;
import com.example.rishabh.projectinterview.retrofit.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThreadsFragment extends Fragment {

    RecyclerView mRecyclerView;
    ThreadsRecyclerAdapter threadsRecyclerAdapter;
    Context mContext;
    List<ThreadsResponseModel> threadsResponseModels;

    public ThreadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_threads, container, false);
        mRecyclerView = view.findViewById((R.id.reyclerview_threads_list));
        mContext = this.getActivity();
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        Call<List<ThreadsResponseModel>> call = retrofitInterface.getThreads();
        call.enqueue(new Callback<List<ThreadsResponseModel>>() {
            @SuppressLint("NewApi")
            @Override
            public void onResponse(@NonNull Call<List<ThreadsResponseModel>> call,
                                   @NonNull Response<List<ThreadsResponseModel>> response) {
                Log.d("API_Response", response + "");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("API_Response", response.body() + "");
                        threadsResponseModels = response.body();

                        threadsRecyclerAdapter = new ThreadsRecyclerAdapter(getActivity(), threadsResponseModels);
                        mRecyclerView.setHasFixedSize(true);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        mRecyclerView.setAdapter(threadsRecyclerAdapter);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ThreadsResponseModel>> call, @NonNull Throwable t) {
                Log.d("API_Response", call+""+t);
            }
        });

        return view;
    }

}
