package com.liebersonsantos.appfilmes.ui;

import com.liebersonsantos.appfilmes.model.Filme;
import com.liebersonsantos.appfilmes.model.mapper.MovieMapper;
import com.liebersonsantos.appfilmes.netWork.ApiService;
import com.liebersonsantos.appfilmes.netWork.response.MovieResult;
import com.liebersonsantos.appfilmes.utils.Constantes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMoviePresenter implements ListMovieContract.ListMoviePresenter{

    private ListMovieContract.ListMovieView view;

    public ListMoviePresenter(ListMovieContract.ListMovieView view) {
        this.view = view;
    }

    @Override
    public void setView(ListMovieContract.ListMovieView view) {
        this.view = view;

    }

    @Override
    public void getMovieAPi() {

        ApiService.getInstance().getPopularMovies(Constantes.API_KEY).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {

                if (response.isSuccessful()){ /* statu code >= 200 || < 300*/

                    final List<Filme> listaFilmes = MovieMapper.responseToDomain(response.body().getResults());
                    view.showMovie(listaFilmes);

                }else {
                    view.showError();
                }

            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

                view.showError();
            }
        });

    }

    @Override
    public void viewDestroy() {
        this.view = null;
    }
}
