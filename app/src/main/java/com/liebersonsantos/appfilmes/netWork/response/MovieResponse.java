package com.liebersonsantos.appfilmes.netWork.response;

import com.squareup.moshi.Json;

public class MovieResponse {

    @Json(name = "poster_path")
    private final String poster_path;

    @Json(name = "original_title")
    private final String original_title;

    public MovieResponse(String poster_path, String original_title) {
        this.poster_path = poster_path;
        this.original_title = original_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }
}
