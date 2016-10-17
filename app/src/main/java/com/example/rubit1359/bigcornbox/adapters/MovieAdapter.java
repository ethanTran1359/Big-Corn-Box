package com.example.rubit1359.bigcornbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rubit1359.bigcornbox.R;
import com.example.rubit1359.bigcornbox.model.Movie;
import com.example.rubit1359.bigcornbox.model.NowPlaying;
import com.example.rubit1359.bigcornbox.ui.MainActivity;
import com.example.rubit1359.bigcornbox.utils.Constant;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;

import static android.R.string.yes;
import static android.view.View.GONE;

/**
 * Created by rubit1359 on 10/14/2016.
 */

public class MovieAdapter extends BaseAdapter {
    private Context mContext;
    // Add mVar of resource, an array for example
    private List<Movie> mMovies;


    // Automatically create constructor for all mVar


    public MovieAdapter(Context context, List<Movie> movies) {
        mContext = context;
        mMovies = movies;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_movie_item, parent, false);
            // Get layout from the context and inflate it the daily_list_item.
            // Use ViewHolder to create smooth scrolling list
            holder = new ViewHolder(convertView);
            // Set the tag for reuse the View
            holder.mMiddleRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.rlMiddleLayout);
            holder.mMiddleBackdrop = (ImageView) convertView.findViewById(R.id.imgMiddleBackDrop);
            holder.mMiddleTitle = (TextView) convertView.findViewById(R.id.tvMiddleTitle);
            holder.mMiddleOverview = (TextView) convertView.findViewById(R.id.tvMiddleOverview);

            holder.mLeftRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.rlLeftLayout);
            holder.mLeftTitle = (TextView) convertView.findViewById(R.id.tvLeftTitle);
            holder.mLeftOverview = (TextView) convertView.findViewById(R.id.tvLeftOverview);
            holder.mLeftPoster = (ImageView) convertView.findViewById(R.id.imgLeftPoster);
            holder.mLeftScoreBackground = (ImageView) convertView.findViewById(R.id
                    .imgLeftScoreBackground);

            holder.mRightRelativeLayout = (RelativeLayout) convertView.findViewById(R.id
                    .rlRightLayout);
            holder.mRightTitle = (TextView) convertView.findViewById(R.id.tvRightTitle);
            holder.mRightOverview = (TextView) convertView.findViewById(R.id.tvRightOverview);
            holder.mRightPoster = (ImageView) convertView.findViewById(R.id.imgRightPoster);
            holder.mRightScoreBackground = (ImageView) convertView.findViewById(R.id
                    .imgRightScoreBackground);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
// Maybe we should remove the right side for testing?
        //Set content to holderVar from get
        //Create the ModelClass object as an element in the array
        // Remember even the Image need to be set (different from MainAct)
        Movie movie = mMovies.get(position);
        Double rate = Double.valueOf(movie.getVoteAverage());
        if (rate > 5) {

            holder.mLeftRelativeLayout.setVisibility(GONE);
            holder.mRightRelativeLayout.setVisibility(GONE);

            Glide.with(mContext).load(movie.getBackdropPath()).into(holder.mMiddleBackdrop);
            holder.mMiddleTitle.setText(movie.getTitle());
            holder.mMiddleOverview.setText(movie.getOverview());
            holder.mMiddleRelativeLayout.setVisibility(View.VISIBLE);
        } else {
            if (position % 2 == 0) {
                holder.mLeftTitle.setText(movie.getOriginalTitle());
                holder.mMiddleRelativeLayout.setVisibility(View.GONE);
                holder.mLeftOverview.setText(movie.getOverview());
                Glide.with(mContext).load(movie.getPosterPath()).placeholder(R.drawable
                        .placeholder).into(holder
                        .mLeftPoster);
                holder.mRightRelativeLayout.setVisibility(GONE);
                holder.mLeftRelativeLayout.setVisibility(View.VISIBLE);

            } else if (position % 2 == 1) {
                holder.mRightTitle.setText(movie.getOriginalTitle());
                holder.mMiddleRelativeLayout.setVisibility(View.GONE);
                holder.mRightOverview.setText(movie.getOverview());
                Glide.with(mContext).load(movie.getPosterPath()).placeholder(R.drawable
                        .placeholder).into(holder
                        .mRightPoster);
                holder.mLeftRelativeLayout.setVisibility(GONE);
                holder.mRightRelativeLayout.setVisibility(View.VISIBLE);

            }
        }

        // Phat Phat suggest that using the FindViewById instead of butterknife in the Adapter.
        // strange
        //

        return convertView;
    }

    // Create class ViewHolder with Widget as variable based on Model class
    private class ViewHolder {
        // Using ButterKnife to create and hook Widget (remember the Image, too)
        RelativeLayout mMiddleRelativeLayout;
        ImageView mMiddleBackdrop;
        TextView mMiddleTitle;
        TextView mMiddleOverview;

        RelativeLayout mLeftRelativeLayout;
        TextView mLeftTitle;
        TextView mLeftOverview;
        TextView mLeftCast;
        ImageView mLeftPoster;
        ImageView mLeftScoreBackground;

        RelativeLayout mRightRelativeLayout;
        TextView mRightTitle;
        TextView mRightOverview;
        TextView mRightCast;
        ImageView mRightPoster;
        ImageView mRightScoreBackground;


        ViewHolder(View view) {
        }
    }
}
