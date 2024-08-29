package com.example.recycleview.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.activity.model.Filme;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.MyViewHolderFilmes> {

    private List<Filme> listaFilmes;

    public AdapterFilmes(List<Filme> lista) {
        this.listaFilmes = lista;
    }

    @NonNull
    @Override
    public MyViewHolderFilmes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Criar as views que serão exibidas na tela

        //LayoutInflater converte o xml em uma view
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista_filmes,
                        parent,
                        false);

        return new MyViewHolderFilmes(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderFilmes holder, int position) {
        //utilizado para autalizar as views exibidas na tela

        //holder recebido do MyViewHolderFilmes

        Filme filme = listaFilmes.get(position);
        holder.titulo.setText(filme.getTituloFilme());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());
    }

    @Override
    public int getItemCount() {
        return this.listaFilmes.size();
    }

    public class MyViewHolderFilmes extends RecyclerView.ViewHolder{

        TextView titulo, ano, genero;

        public MyViewHolderFilmes(@NonNull View itemView) {
            super(itemView);

            //itemView passado no onCreateViewHolder, que serão passados para onBindViewHolder
            titulo = itemView.findViewById(R.id.textTitulo);
            ano = itemView.findViewById(R.id.textAno);
            genero = itemView.findViewById(R.id.textGenero);
        }
    }
}
