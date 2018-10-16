package com.example.rishabh.projectinterview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.models.CodesModels;
import com.example.rishabh.projectinterview.models.QnAModel;

import java.util.List;

public class CodesRecyclerAdapter extends RecyclerView.Adapter<CodesRecyclerAdapter.CodesViewHolder> {


    Context context;
    List<CodesModels> codesModelsList;
    public CodesRecyclerAdapter(Context context, List<CodesModels> threadsResponseModels) {
        this.context = context;
        this.codesModelsList = threadsResponseModels;
    }


    @NonNull
    @Override
    public CodesRecyclerAdapter.CodesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.codes_item_layout, parent, false);
        return new CodesRecyclerAdapter.CodesViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CodesRecyclerAdapter.CodesViewHolder holder, int position) {
//        holder.tvQues.setText(codesModelsList.get(position).getText());
        holder.tvUpvote.setText(codesModelsList.get(position).getUpvotes() + "");
        holder.tvDownVote.setText(codesModelsList.get(position).getDownvotes() + "");
        holder.tvComment.setText(codesModelsList.get(position).getComments() + "");
        holder.tvProg.setText(codesModelsList.get(position).getCodeLanguage() + "");
        holder.tvTitle.setText(codesModelsList.get(position).getCode() + "");
        holder.tvUser.setText(codesModelsList.get(position).getUserName() + "");

    }

    @Override
    public int getItemCount() {
        return codesModelsList.size();
    }

    public class CodesViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvUpvote, tvProg, tvComment, tvDownVote, tvUser;

        public CodesViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title_code);
            tvUpvote = itemView.findViewById(R.id.upvote_qna);
            tvProg = itemView.findViewById(R.id.prog_code);
            tvComment = itemView.findViewById(R.id.comment_code);
            tvDownVote= itemView.findViewById(R.id.downvote_qna);
            tvUser = itemView.findViewById(R.id.username_codes);
        }
    }
}
