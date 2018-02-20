package com.example.somil.recyclerviewfinal;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private MoviesAdapter madapter;
    List<Movies> movies = new ArrayList<>();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView)MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setMoviesAdapter();
        setRecyclerView();
    }
    private void setMoviesAdapter(){

        try{
            InputStreamReader is=new InputStreamReader(getAssets().open("movies.csv"));
            BufferedReader reader=new BufferedReader(is);
            reader.readLine();
            String line;
            String st[];
            while((line=reader.readLine())!=null)
            {
                st=line.split(",");
                Movies movie=new Movies();
                movie.setTitle(st[0]);
                movie.setRating(Float.parseFloat(st[3]));
                movie.setRuntime(Integer.parseInt(st[1]));
                movie.setTagline(st[2]);
                movies.add(movie);


            }

        }
        catch (IOException e){

        }
        madapter=new MoviesAdapter(movies);


    }
    private void setRecyclerView(){
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(madapter);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Movies> newlist=new ArrayList<>();
        for(Movies movie:movies)
        {
            String name=movie.getTitle().toLowerCase();
            if(name.contains(newText))
            {
                newlist.add(movie);
            }
        }
        madapter.setFilter(newlist);
        return false;
    }
}
