package com.example.flickfetch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbApiService {
    @GET("/")
    Call<Movie> getMovieInfo(
            @Query("apikey") String apiKey,
            @Query("t") String title
    );
}
