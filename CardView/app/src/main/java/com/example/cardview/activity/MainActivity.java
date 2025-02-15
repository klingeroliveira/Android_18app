package com.example.cardview.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.adapter.PostagemAdapter;
import com.example.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagemList = new ArrayList<>();

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

        //Postagens que serão inseridas na tela
        criarPostagens();

        //obtem recyclerView do xml principal
        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //configura o layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerPostagem.setLayoutManager(layoutManager);
        recyclerPostagem.setHasFixedSize(true);

        //configura o adapter
        PostagemAdapter postagemAdapter = new PostagemAdapter(postagemList);
        recyclerPostagem.setAdapter(postagemAdapter);
    }

    public void criarPostagens() {
        Postagem postagem;
        int contador = 1;
        int imagem = 1;
        for (int i = 0; i < 20; i++) {

            switch (contador)
            {
                case 1: imagem = R.drawable.imagem1;
                break;
                case 2: imagem = R.drawable.imagem2;
                break;
                case 3: imagem = R.drawable.imagem3;
                break;
                case 4: imagem = R.drawable.imagem4;
                break;
                default: contador = 1;
                    imagem = R.drawable.imagem1;
                    break;
            }
            postagem = new Postagem("Autor da Postagem " + i, Calendar.getInstance().getTime(), "Legenda postagem " + i, imagem);
            postagemList.add(postagem);
            contador++;
        }
    }
}