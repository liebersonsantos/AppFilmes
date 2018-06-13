package com.liebersonsantos.appfilmes.netWork.response;

import com.squareup.moshi.Json;

import java.util.List;

public class MovieResult {

    @Json(name = "results")
    private final List<MovieResponse> results;

    public MovieResult(List<MovieResponse> results) {
        this.results = results;
    }

    public List<MovieResponse> getResults() {
        return results;
    }
}
