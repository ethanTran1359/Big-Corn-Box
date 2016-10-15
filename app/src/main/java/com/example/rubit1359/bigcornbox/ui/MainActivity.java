package com.example.rubit1359.bigcornbox.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rubit1359.bigcornbox.R;
import com.example.rubit1359.bigcornbox.adapters.MovieAdapter;
import com.example.rubit1359.bigcornbox.api.MovieApi;
import com.example.rubit1359.bigcornbox.model.Movie;
import com.example.rubit1359.bigcornbox.model.NowPlaying;
import com.example.rubit1359.bigcornbox.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    MovieAdapter mAdapter;
    List<Movie> mMovies;// = new ArrayList<Movie>();

    private NowPlaying mNowPlaying;

    //@BindView(R.id.list)
    ListView mListView;
    @BindView(android.R.id.empty)
    TextView mEmptyView;
    private MovieApi mMovieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mListView = (ListView) findViewById(R.id.list);


//        final MovieAdapter adapter = new MovieAdapter(this, mMovies);

//
        mMovieApi = RetrofitUtils.get(getString(R.string.api_key)).create(MovieApi.class);
        mMovieApi.getNowPlaying().enqueue(new Callback<NowPlaying>() {

            @Override
            public void onResponse(Call<NowPlaying> call, Response<NowPlaying> response) {

                Log.d("Response", String.valueOf(response.isSuccessful()));
                mMovies = response.body().getMovies();
                mAdapter = new MovieAdapter(this, mMovies);
                mListView.setAdapter(mAdapter);
                mListView.setEmptyView(mEmptyView);



            }

            @Override
            public void onFailure(Call<NowPlaying> call, Throwable t) {
                Log.e("Error", t.getMessage());
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();



            }
        });



    }
}
