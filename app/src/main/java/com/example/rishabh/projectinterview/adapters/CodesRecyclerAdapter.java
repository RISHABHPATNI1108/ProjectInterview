package com.example.rishabh.projectinterview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.models.CodesModels;
import com.example.rishabh.projectinterview.models.QnAModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        holder.tvdays.setText(getDate(codesModelsList.get(position).getTime(), "dd/MM/yyyy"));

        Glide
                .with(context)
                .load(codesModelsList.get(position).getUserImageUrl())
                .into(holder.imgCode);
    }

    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    @Override
    public int getItemCount() {
        return codesModelsList.size();
    }

    public class CodesViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvUpvote, tvProg, tvComment, tvDownVote, tvUser, tvdays;
        ImageView imgCode;

        public CodesViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title_code);
            tvUpvote = itemView.findViewById(R.id.upvote_qna);
            tvProg = itemView.findViewById(R.id.prog_code);
            tvdays = itemView.findViewById(R.id.date_code);
            tvComment = itemView.findViewById(R.id.comment_code);
            tvDownVote= itemView.findViewById(R.id.downvote_qna);
            tvUser = itemView.findViewById(R.id.username_codes);
            imgCode = itemView.findViewById(R.id.image_code);
        }
    }
}
