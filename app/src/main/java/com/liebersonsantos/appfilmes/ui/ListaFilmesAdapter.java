package com.liebersonsantos.appfilmes.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liebersonsantos.appfilmes.R;
import com.liebersonsantos.appfilmes.model.Filme;
import com.liebersonsantos.appfilmes.utils.Constantes;
import com.liebersonsantos.appfilmes.utils.ImageUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewholder>{

    private List<Filme> filmes;

    public ListaFilmesAdapter(){
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { /*INFLANDO LAYOUT PARA OS ITENS DA LISTA*/

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewholder holder, int position) { /*SENTANDO VALORES NA LISTA*/

       holder.bind(filmes.get(position));

    }

    @Override
    public int getItemCount() { /*PARA CADA ITEM QUE EXISTE NA LISTA*/
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0 ;
        /*SE FILMES FOR DIFERENTE DE NULL E MAIOR QUE 0 ENTAO RETORNA FILMES(TAMANHO DA LISTA DE FILMES). SENAO RETORNA ZERO*/
    }

    static class ListaFilmesViewholder extends RecyclerView.ViewHolder{

        private TextView txtMovieTitle;
        private ProgressBar progressBar;
        private ImageView imagePoster;


        public ListaFilmesViewholder(View itemView) { /*SETANDO AS VIEWS*/
            super(itemView);

            txtMovieTitle = itemView.findViewById(R.id.txt_movie_title);
            progressBar = itemView.findViewById(R.id.progress_bar);
            imagePoster = itemView.findViewById(R.id.image_view);

        }

        public void bind(Filme filme){

            txtMovieTitle.setText(filme.getTitle());
            /*##PICASSO##*/
            ImageUtil.loadImage(Constantes.BASE_URL_IMAGE + filme.getPoster_path(), imagePoster, progressBar, R.drawable.ic_launcher_foreground);

        }
    }

    public void setMovies(List<Filme> filmes){
        this.filmes = filmes;
        notifyDataSetChanged();
    }



}
