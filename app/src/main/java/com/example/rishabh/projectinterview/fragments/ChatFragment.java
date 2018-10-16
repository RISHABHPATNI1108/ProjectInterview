
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
import com.example.rishabh.projectinterview.models.ChatResponseModel;
import com.example.rishabh.projectinterview.retrofit.ApiClient;
import com.example.rishabh.projectinterview.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private RecyclerView mMessageRecycler;
    private MessageRecyclerAdapter mMessageAdapter;
    private List<ChatResponseModel> chatResponseModel;
    private Context mContext;
    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        chatResponseModel = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        mMessageRecycler = (RecyclerView) view.findViewById(R.id.reyclerview_message_list);
        mContext = this.getActivity();
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        Call<List<ChatResponseModel>> call = retrofitInterface.getChat();
        call.enqueue(new Callback<List<ChatResponseModel>>() {
            @SuppressLint("NewApi")
            @Override
            public void onResponse(@NonNull Call<List<ChatResponseModel>> call,
                                   @NonNull Response<List<ChatResponseModel>> response) {
                Log.d("API_Response", response+"");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("API_Response", response.body()+"");
                        chatResponseModel = response.body();
                        mMessageAdapter = new MessageRecyclerAdapter(mContext, chatResponseModel);
                        mMessageRecycler.setLayoutManager(new LinearLayoutManager(mContext));
                        mMessageRecycler.setHasFixedSize(true);
                        mMessageRecycler.setAdapter(mMessageAdapter);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ChatResponseModel>> call, @NonNull Throwable t) {
                Log.d("API_Response", call+""+t);
            }
        });


        return view;
    }

}
