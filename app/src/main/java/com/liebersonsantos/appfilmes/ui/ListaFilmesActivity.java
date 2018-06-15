package com.liebersonsantos.appfilmes.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liebersonsantos.appfilmes.R;
import com.liebersonsantos.appfilmes.model.Filme;
import com.liebersonsantos.appfilmes.model.mapper.MovieMapper;
import com.liebersonsantos.appfilmes.netWork.ApiService;
import com.liebersonsantos.appfilmes.netWork.response.MovieResult;
import com.liebersonsantos.appfilmes.utils.Constantes;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity implements ListMovieContract.ListMovieView{

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private ListaFilmesAdapter filmesAdapter;
    ListMovieContract.ListMoviePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        presenter = new ListMoviePresenter(this);

        initViews();
        settingsAdapter();
        presenter.getMovieAPi();
    }

    private void initViews() {

        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recycler_view);

    }


    @Override
    public void showMovie(List<Filme> filmeList) {

        filmesAdapter.setMovies(filmeList);
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Erro ao obter lista dos filmes", Toast.LENGTH_SHORT).show();
    }

    private void settingsAdapter(){

        filmesAdapter = new ListaFilmesAdapter();

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(filmesAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.viewDestroy(); //quando a activity for destruida, o presenter perderá a referencia da mesma
    }

    //    private List<Filme> createDataMovie() { //METODO PARA CRIAR LISTA FICTICIA PARA TESTE
//        return Arrays.asList(
//                new Filme("Corações de Ferro"),
//                new Filme("Corações de Ferro"),
//                new Filme("Corações de Ferro"));
//    }


}
