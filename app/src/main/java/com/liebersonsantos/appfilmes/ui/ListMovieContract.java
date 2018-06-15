package com.liebersonsantos.appfilmes.ui;

import com.liebersonsantos.appfilmes.model.Filme;

import java.util.List;

public interface ListMovieContract {

    interface ListMovieView{

        void showMovie(List<Filme> filmeList);
        void showError();
    }

    interface ListMoviePresenter{

        void setView(ListMovieView view);
        void getMovieAPi();
        void viewDestroy();
    }

}
