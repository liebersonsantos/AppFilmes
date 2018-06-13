package com.liebersonsantos.appfilmes.netWork;

import com.liebersonsantos.appfilmes.netWork.response.MovieResult;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("movie/popular")
    Call<MovieResult>getPopularMovies(@Query("api_key") String apiKey);

}
