package com.example.dig.dig_t1;

/**
 * Created by rodrigo on 11/09/16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private List<Comment> commentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView authorName, comment, timeComment;

        public MyViewHolder(View view) {
            super(view);
            authorName = (TextView) view.findViewById(R.id.authorName);
            comment = (TextView) view.findViewById(R.id.comment);
            timeComment = (TextView) view.findViewById(R.id.timeComment);
        }
    }


    public CommentAdapter(List<Comment> moviesList) {
        this.commentList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Comment comment = commentList.get(position);

        holder.authorName.setText(comment.getAuthorName());
        holder.timeComment.setText(comment.getTimeComment());
        holder.comment.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}