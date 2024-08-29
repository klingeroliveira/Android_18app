package com.example.recycleview.activity.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.activity.adapter.AdapterFilmes;
import com.example.recycleview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerFilmes;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerFilmes = findViewById(R.id.recyclerFilmes);

        //Listagem de filmes
        this.criarFilmes();

        //Configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);

        //Configurar recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerFilmes.setLayoutManager(layoutManager);
        recyclerFilmes.setHasFixedSize(true); //recomendado pela google para melhor performance
        recyclerFilmes.setAdapter(adapterFilmes);

    }

    public void criarFilmes(){
        Filme filme;
        for (int i = 1; i <= 80; i++) {
            filme = new Filme(i + "º Filme gerado no for", "20" + i, "Genero");
            listaFilmes.add(filme);
        }
    }
}