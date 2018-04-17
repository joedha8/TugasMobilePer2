package com.gmail.yudhapratama539.belajarlayout.Pertemuan6;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.yudhapratama539.belajarlayout.R;

import java.util.List;

/**
 * Created by joedhaalzelvin on 11/04/18.
 */

public class RecyclerViewMovie extends RecyclerView.Adapter<RecyclerViewMovie.ViewHolder>{
    private List<Movie> movieList;
    private Context context;

    public RecyclerViewMovie(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_main, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie=movieList.get(position);

        holder.textViewJudul.setText(movie.getTitle());
        holder.textViewYear.setText(movie.getYear());
        holder.textViewGenre.setText(movie.getGenre());
        holder.textViewRating.setText(movie.getRating());
        holder.imageViewMovie.setBackground(ContextCompat.getDrawable(context, movie.getGambar()));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewJudul, textViewYear, textViewGenre, textViewRating;
        public ImageView imageViewMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewJudul=itemView.findViewById(R.id.tv_title);
            textViewYear=itemView.findViewById(R.id.tv_year);
            textViewGenre=itemView.findViewById(R.id.tv_genre);
            textViewRating=itemView.findViewById(R.id.tv_rating);
            imageViewMovie=itemView.findViewById(R.id.ivMovie);
        }
    }
}

