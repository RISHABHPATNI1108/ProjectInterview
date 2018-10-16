package com.example.rishabh.projectinterview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.models.ThreadsResponseModel;

import java.util.List;

public class ThreadsRecyclerAdapter extends RecyclerView.Adapter<ThreadsRecyclerAdapter.ThreadsViewHolder> {


    Context context;
    List<ThreadsResponseModel> threadsResponseModelList;
    public ThreadsRecyclerAdapter(Context context, List<ThreadsResponseModel> threadsResponseModels) {
        this.context = context;
        this.threadsResponseModelList = threadsResponseModels;
    }


    @NonNull
    @Override
    public ThreadsRecyclerAdapter.ThreadsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.threads_item_layout, parent, false);
            return new ThreadsRecyclerAdapter.ThreadsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ThreadsViewHolder holder, int position) {
        holder.tvTitle.setText(threadsResponseModelList.get(position).getTitle());
        holder.tvTime.setText(threadsResponseModelList.get(position).getTime());
        holder.tvUname.setText(threadsResponseModelList.get(position).getUserName());
        holder.tvTag3.setText(threadsResponseModelList.get(position).getTags().get(0));
        holder.tvTag2.setText(threadsResponseModelList.get(position).getTags().get(1));
        holder.tvTag1.setText(threadsResponseModelList.get(position).getTags().get(2));
        holder.tvText.setText(threadsResponseModelList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return threadsResponseModelList.size();
    }

    public class ThreadsViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvText, tvTag1, tvTag2, tvTag3, tvUname, tvTime;

        public ThreadsViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title_text_threads);
            tvText = itemView.findViewById(R.id.text_threads);
            tvTag1 = itemView.findViewById(R.id.tag1_threads);
            tvTag2 = itemView.findViewById(R.id.tag2_threads);
            tvTag3 = itemView.findViewById(R.id.tag3_threads);
            tvUname = itemView.findViewById(R.id.username_threads);
            tvTime = itemView.findViewById(R.id.time_threads);
        }
    }
}
