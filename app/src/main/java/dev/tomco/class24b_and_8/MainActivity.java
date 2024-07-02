package dev.tomco.class24b_and_8;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

import dev.tomco.class24b_and_8.Adapters.MovieAdapter;
import dev.tomco.class24b_and_8.Models.Movie;
import dev.tomco.class24b_and_8.Utilities.DataManager;
import dev.tomco.class24b_and_8.Utilities.MyBackgroundMusic;
import dev.tomco.class24b_and_8.Utilities.SoundPlayer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_LST_movies;
    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPlayer = new SoundPlayer(this);

//        ArrayList<Movie> movies = DataManager.getMovies();
//
//        Gson gson = new Gson();

//        String moviesAsJson = gson.toJson(movies);
//        Log.d("Movies", "all movies: " + moviesAsJson);
//        ArrayList<Movie> fromJson = gson.fromJson(moviesAsJson,ArrayList.class);
//        Log.d("AL", "onCreate: "+ fromJson.get(0));

        findViews();
        initViews();

    }

    @Override
    protected void onPause() {
        super.onPause();
        MyBackgroundMusic.getInstance().pauseMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyBackgroundMusic.getInstance().playMusic();
    }

    private void initViews() {
        MovieAdapter movieAdapter = new MovieAdapter(DataManager.getMovies());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        main_LST_movies.setLayoutManager(linearLayoutManager);
        main_LST_movies.setAdapter(movieAdapter);
        movieAdapter.setMovieCallback((movie, position) -> {
            movie.setFavorite(!movie.isFavorite());
            movieAdapter.notifyItemChanged(position);
            makeSound();
        });
    }

    private void makeSound() {
        soundPlayer.playSound(R.raw.snd_ding);
    }

    private void findViews() {
        main_LST_movies = findViewById(R.id.main_LST_movies);
    }
}