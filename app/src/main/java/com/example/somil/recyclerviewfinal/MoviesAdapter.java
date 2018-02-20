package com.example.somil.recyclerviewfinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Somil on 2/17/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movies> movies;

    public class MoviesViewHolder extends RecyclerView.ViewHolder{
        private TextView title,tagline,runtime,rating;
        public MoviesViewHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.title);
            tagline=(TextView) itemView.findViewById(R.id.tagline);
            rating=(TextView) itemView.findViewById(R.id.rating);
            runtime=(TextView) itemView.findViewById(R.id.runtime);
        }
    }

    public MoviesAdapter(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_row,parent,false);
        return new MoviesViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movies movie=movies.get(position);
        holder.title.setText(movie.getTitle());
        holder.tagline.setText(movie.getTagline());
        String rating=Float.toString(movie.getRating());
        holder.rating.setText("Rating: "+rating);
        String runtime=Integer.toString(movie.getRuntime());
        holder.runtime.setText("Runtime: "+runtime);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    public void setFilter(ArrayList<Movies> newlist)
    {
        movies=new ArrayList<>();
        movies.addAll(newlist);
        notifyDataSetChanged();
    }
}
