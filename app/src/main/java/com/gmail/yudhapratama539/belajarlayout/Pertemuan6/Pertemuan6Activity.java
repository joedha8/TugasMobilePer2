package com.gmail.yudhapratama539.belajarlayout.Pertemuan6;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmail.yudhapratama539.belajarlayout.R;

import java.util.ArrayList;
import java.util.List;

public class Pertemuan6Activity extends AppCompatActivity {
    private List<Movie> movieList=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewMovie adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan6);

        adapter=new RecyclerViewMovie(movieList, this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());

        recyclerView = findViewById(R.id.rvMain);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        prepareDataMovie();
    }

    private void prepareDataMovie(){
        Movie movie=new Movie("Kimi no Nawa", "2015", "Romance", "4/5", R.drawable.kiminonawa);
        movieList.add(movie);

        Movie movie1=new Movie("Firework", "2017", "Romance", "3/5", R.drawable.firework);
        movieList.add(movie1);

        Movie movie2=new Movie("Sword Art Online", "2017", "Romance, Action, Sci-fi", "5/5", R.drawable.sao);
        movieList.add(movie2);
    }
}
