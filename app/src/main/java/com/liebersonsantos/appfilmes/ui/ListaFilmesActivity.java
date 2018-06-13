package com.liebersonsantos.appfilmes.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.liebersonsantos.appfilmes.R;
import com.liebersonsantos.appfilmes.model.mapper.MovieMapper;
import com.liebersonsantos.appfilmes.utils.Constantes;
import com.liebersonsantos.appfilmes.netWork.ApiService;
import com.liebersonsantos.appfilmes.netWork.response.MovieResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaFilmesActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private ListaFilmesAdapter filmesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_filmes);

        initViews();
        settingsAdapter();
        getMovieAPi();

    }

    private void initViews() {

        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        mRecyclerView = findViewById(R.id.recycler_view);

    }

    private void getMovieAPi() {

        ApiService.getInstance().getPopularMovies(Constantes.API_KEY).enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {

                if (response.isSuccessful()){ /* statu code >= 200 || < 300*/

                    filmesAdapter.setMovies(MovieMapper.responseToDomain(response.body().getResults()));
                }else {

                    showError();
                }

            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

               showError();
            }
        });

    }

    private void showError() {

        Toast.makeText(this, "Erro ao obter lista dos filmes", Toast.LENGTH_SHORT).show();
    }

    private void settingsAdapter(){

        filmesAdapter = new ListaFilmesAdapter();

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setAdapter(filmesAdapter);
    }



    //    private List<Filme> createDataMovie() { //METODO PARA CRIAR LISTA FICTICIA PARA TESTE
//        return Arrays.asList(
//                new Filme("Corações de Ferro"),
//                new Filme("Corações de Ferro"),
//                new Filme("Corações de Ferro"));
//    }


}
