package com.example.rishabh.projectinterview.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.adapters.CodesRecyclerAdapter;
import com.example.rishabh.projectinterview.adapters.QuestionsRecyclerAdapter;
import com.example.rishabh.projectinterview.models.CodesModels;
import com.example.rishabh.projectinterview.models.QnAModel;
import com.example.rishabh.projectinterview.retrofit.ApiClient;
import com.example.rishabh.projectinterview.retrofit.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CodesFragment extends Fragment {

    RecyclerView mRecyclerView;
    CodesRecyclerAdapter questionsRecyclerAdapter;
    Context mContext;
    List<CodesModels> codesModelsList;

    public CodesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_codes, container, false);
        mRecyclerView = view.findViewById((R.id.recyclert_codes));
        mContext = this.getActivity();

        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        Call<List<CodesModels>> call = retrofitInterface.getCodes();
        call.enqueue(new Callback<List<CodesModels>>() {
            @SuppressLint("NewApi")
            @Override
            public void onResponse(@NonNull Call<List<CodesModels>> call,
                                   @NonNull Response<List<CodesModels>> response) {
                Log.d("API_Response", response + "");
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.d("API_Response", response.body() + "");
                        codesModelsList = response.body();

                        questionsRecyclerAdapter = new CodesRecyclerAdapter(getActivity(), codesModelsList);
                        mRecyclerView.setHasFixedSize(true);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                        mRecyclerView.setAdapter(questionsRecyclerAdapter);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<CodesModels>> call, @NonNull Throwable t) {
                Log.d("API_Response", call+""+t);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.actionbar_searchmenu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        MenuItem searchItem = menu.findItem(R.id.search);
        searchItem.expandActionView();

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) item.getActionView();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.ques_filter, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }


}
