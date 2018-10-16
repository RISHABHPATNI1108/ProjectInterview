package com.example.rishabh.projectinterview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.models.QnAModel;
import com.example.rishabh.projectinterview.models.ThreadsResponseModel;

import java.util.List;

public class QuestionsRecyclerAdapter extends RecyclerView.Adapter<QuestionsRecyclerAdapter.QnsViewHolder> {


    Context context;
    List<QnAModel> threadsResponseModelList;
    public QuestionsRecyclerAdapter(Context context, List<QnAModel> threadsResponseModels) {
        this.context = context;
        this.threadsResponseModelList = threadsResponseModels;
    }


    @NonNull
    @Override
    public QuestionsRecyclerAdapter.QnsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.qna_layout, parent, false);
        return new QuestionsRecyclerAdapter.QnsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull QuestionsRecyclerAdapter.QnsViewHolder holder, int position) {
        holder.tvQues.setText(threadsResponseModelList.get(position).getText());
        holder.tvUpvote.setText(threadsResponseModelList.get(position).getUpvotes() + "");
        holder.tvDownVote.setText(threadsResponseModelList.get(position).getDownvotes() + "");
        holder.tvTag3.setText(threadsResponseModelList.get(position).getTags().get(0));
        holder.tvTag2.setText(threadsResponseModelList.get(position).getTags().get(1));
        holder.tvTag1.setText(threadsResponseModelList.get(position).getTags().get(2));
        holder.tvDate.setText(threadsResponseModelList.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return threadsResponseModelList.size();
    }

    public class QnsViewHolder extends RecyclerView.ViewHolder {

        TextView tvQues, tvUpvote, tvTag1, tvTag2, tvTag3, tvDownVote, tvDate;

        public QnsViewHolder(View itemView) {
            super(itemView);
            tvQues = itemView.findViewById(R.id.ques_qna);
            tvUpvote = itemView.findViewById(R.id.upvote_qna);
            tvTag1 = itemView.findViewById(R.id.tag1_threads);
            tvTag2 = itemView.findViewById(R.id.tag2_threads);
            tvTag3 = itemView.findViewById(R.id.tag3_threads);
            tvDownVote= itemView.findViewById(R.id.downvote_qna);
            tvDate = itemView.findViewById(R.id.date_bu_uname);
        }
    }
}
