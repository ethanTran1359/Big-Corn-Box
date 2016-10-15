package com.example.rubit1359.bigcornbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rubit1359.bigcornbox.R;
import com.example.rubit1359.bigcornbox.model.Movie;
import com.example.rubit1359.bigcornbox.model.NowPlaying;
import com.example.rubit1359.bigcornbox.ui.MainActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;

/**
 * Created by rubit1359 on 10/14/2016.
 */

public class MovieAdapter extends BaseAdapter{
    private Context mContext;
    // Add mVar of resource, an array for example
    private List<Movie> mMovies;



    // Automatically create constructor for all mVar


    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
    }

    public MovieAdapter(Callback<NowPlaying> callback, List<Movie> movies) {
    }


    // Automatically create required methods and override them with mVar
    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0; // Use to easier get position reference
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            // If the ListView is brand new

            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_movie_item,
                    parent, false);
            // Get layout from the context and inflate it the daily_list_item.

            // Use ViewHolder to create smooth scrolling list

            holder = new ViewHolder(convertView);

            // Set the tag for reuse the View
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Set content to holderVar from get
        //Create the ModelClass object as an element in the array
        // Remember even the Image need to be set (different from MainAct)
        Movie movie = mMovies.get(position);
        holder.mTvLeftTitle.setText(movie.getTitle());
        holder.mTvLeftOverview.setText(movie.getOverview());
//        holder.mTvLeftCast.setText(movie.getCast());
        Glide.with(mContext)
                .load(movie.getPosterPath())
                .into(holder.mImgLeftPoster);

        holder.mTvRightTitle.setText(movie.getTitle());
        holder.mTvRightOverview.setText(movie.getOverview());
//        holder.mTvLeftCast.setText(movie.getCast());
        Glide.with(mContext)
                .load(movie.getPosterPath())
                .into(holder.mImgRightPoster);


        return convertView;
    }

    // Create class ViewHolder with Widget as variable based on Model class
    static class ViewHolder {
        // Using ButterKnife to create and hook Widget (remember the Image, too)
        @BindView(R.id.rlLeftLayout)
        RelativeLayout mRlLeftLayout;
        @BindView(R.id.tvLeftTitle)
        TextView mTvLeftTitle;
        @BindView(R.id.tvLeftOverview)
                TextView mTvLeftOverview;
        @BindView(R.id.tvLeftCast)
        TextView mTvLeftCast;
        @BindView(R.id.imgLeftPoster)
        ImageView mImgLeftPoster;

        @BindView(R.id.rlRightLayout)
        RelativeLayout mRlRightLayout;
        @BindView(R.id.tvRightTitle)
        TextView mTvRightTitle;
        @BindView(R.id.tvRightOverview)
        TextView mTvRightOverview;
        @BindView(R.id.tvRightCast)
        TextView mTvRightCast;
        @BindView(R.id.imgRightPoster)
        ImageView mImgRightPoster;


        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
