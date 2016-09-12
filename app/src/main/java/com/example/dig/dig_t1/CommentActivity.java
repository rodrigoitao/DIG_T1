package com.example.dig.dig_t1;

/**
 * Created by rodrigo on 11/09/16.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {
    private List<Comment> commentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CommentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_comment);

        mAdapter = new CommentAdapter(commentList);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        Comment comment = new Comment("André Bon Odori", "Muito bom", "Há 1 minuto", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hmmm", "Há 2 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hmmmm", "Há 3 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hmmmmm", "Há 4 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hmmmmmm", "Há 5 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hmmmmmmmm", "Há 6 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "Bon odori", "Há 7 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "flango", "Há 8 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "flooders", "Há 9 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "pastel", "Há 10 minutos", R.drawable.toshio);
        commentList.add(comment);

        comment = new Comment("André Bon Odori", "hey", "Há 11 minutos", R.drawable.toshio);
        commentList.add(comment);


        mAdapter.notifyDataSetChanged();
    }
}