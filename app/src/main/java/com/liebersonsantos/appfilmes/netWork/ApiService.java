package com.liebersonsantos.appfilmes.netWork;

import com.liebersonsantos.appfilmes.utils.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiService {

    private static MovieService movieService;

    public static MovieService getInstance(){

        if (movieService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();

            movieService = retrofit.create(MovieService.class);

        }

        return movieService;

    }

}
