package com.example.rubit1359.bigcornbox.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubit1359 on 10/14/2016.
 */

public class NowPlaying {
    @SerializedName("results")
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
