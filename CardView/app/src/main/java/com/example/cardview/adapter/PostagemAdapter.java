package com.example.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.model.Postagem;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolderPostagem> {

    private List<Postagem> listPostagem;

    public PostagemAdapter(List<Postagem> listPostagem) {
        this.listPostagem = listPostagem;
    }

    @NonNull
    @Override
    public MyViewHolderPostagem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_postagem,
                        parent,
                        false);
        return new MyViewHolderPostagem(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderPostagem holder, int position) {
        Postagem postagem = listPostagem.get(position);
        holder.textAutor.setText(postagem.getAutor());
        holder.textTempo.setText(postagem.getData().toString());
        holder.textLegenda.setText(postagem.getLegenda());
        holder.imagem.setImageResource(postagem.getImagem());
    }

    @Override
    public int getItemCount() {
        return this.listPostagem.size();
    }

    public class MyViewHolderPostagem extends RecyclerView.ViewHolder {

        TextView textAutor, textTempo, textLegenda;
        ImageView imagem;

        public MyViewHolderPostagem(@NonNull View itemView) {
            super(itemView);

            textAutor = itemView.findViewById(R.id.textAutor);
            textTempo = itemView.findViewById(R.id.textTempo);
            textLegenda = itemView.findViewById(R.id.textLegenda);
            imagem = itemView.findViewById(R.id.imagePostagem);
        }
    }
}
