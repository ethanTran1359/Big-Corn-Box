package com.example.rubit1359.bigcornbox.model;

import com.example.rubit1359.bigcornbox.utils.Constant;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rubit1359 on 10/13/2016.
 */

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;// portrait mode
    @SerializedName("adult")
    private Boolean adult;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("genre_ids")
    private String[] genreIds;
    @SerializedName("id")
    private int id;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("original_language")
    private String originalLanguage;
    @SerializedName("title")
    private String title;
    @SerializedName("backdrop_path")
    private String backdropPath; // landscape mode
    @SerializedName("popularity")
    private String popularity;
    @SerializedName("vote_count")
    private String voteCount;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_average")
    private String voteAverage;

    public String getPosterPath() {
        return Constant.STATIC_BASE + posterPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String[] getGenreIds() {
        return genreIds;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public String getBackdropPath() {
        return Constant.STATIC_BASE + backdropPath;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public String getVoteAverage() {
        return voteAverage;
    }
}
