package com.example.rubit1359.bigcornbox.adapters;

import android.content.Context;
import android.graphics.Movie;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by rubit1359 on 10/17/2016.
 */

public class MovieAdapters extends ArrayAdapter<Movie>{


    public MovieAdapters(Context context, int resource) {
        super(context, resource);
    }

    public MovieAdapters(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public MovieAdapters(Context context, int resource, Movie[] objects) {
        super(context, resource, objects);
    }

    public MovieAdapters(Context context, int resource, int textViewResourceId, Movie[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public MovieAdapters(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
    }

    public MovieAdapters(Context context, int resource, int textViewResourceId, List<Movie> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
