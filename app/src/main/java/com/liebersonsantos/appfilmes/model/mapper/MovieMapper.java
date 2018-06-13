package com.liebersonsantos.appfilmes.model.mapper;

import com.liebersonsantos.appfilmes.model.Filme;
import com.liebersonsantos.appfilmes.netWork.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class MovieMapper {


    public static List<Filme> responseToDomain(List<MovieResponse> listMovieRespose){

        List<Filme> listMovie = new ArrayList<>();

        for (MovieResponse movieResponse : listMovieRespose){

            final Filme filme = new Filme(movieResponse.getOriginal_title(), movieResponse.getPoster_path());
            listMovie.add(filme);
        }
        return listMovie;
    }

}
