package com.example.rubit1359.bigcornbox.api;

import com.example.rubit1359.bigcornbox.model.NowPlaying;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rubit1359 on 10/14/2016.
 */

public interface MovieApi {
    @GET("now_playing")
    Call<NowPlaying> getNowPlaying();
}


//how do you run the in mobile or genymotion// on my real device//anyway but now we can run on
// real device as there is no UIok
//  b.ut owe kcan run on genymotion