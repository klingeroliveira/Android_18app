package com.example.recycleview.activity.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;
import com.example.recycleview.activity.RecyclerItemClickListener;
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
        //recomendado pela google para melhor performance
        recyclerFilmes.setHasFixedSize(true);
        //insere um divisor na orientação indicada no parâmetro
        recyclerFilmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerFilmes.setAdapter(adapterFilmes);

        //Configurar click
        recyclerFilmes.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerFilmes,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),
                                    "Item pressionado: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Filme filme = listaFilmes.get(position);

                            Toast.makeText(getApplicationContext(),
                                    "Click Longo: " + filme.getTituloFilme(),
                                    Toast.LENGTH_SHORT);
                        }

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    }
            )
        );

    }

    public void criarFilmes(){
        Filme filme;
        for (int i = 1; i <= 80; i++) {

            filme = new Filme(i + "º Filme gerado no for", "20" + String.format("%02d", i), "Genero");
            listaFilmes.add(filme);
        }
    }
}