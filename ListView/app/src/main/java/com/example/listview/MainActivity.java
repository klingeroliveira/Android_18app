package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listCidades;
    private String[] cidades = {"ALTA FLORESTA D OESTE","ARIQUEMES",
"CABIXI","CACOAL","CEREJEIRAS","COLORADO DO OESTE",
"CORUMBIARA","COSTA MARQUES","ESPIGAO D OESTE","GUAJARA MIRIM",
"JARU","JI PARANA","MACHADINHO D OESTE",
"NOVA BRASILANDIA D OESTE","OURO PRETO DO OESTE","PIMENTA BUENO","PORTO VELHO","PRESIDENTE MEDICI","RIO CRESPO",
"ROLIM DE MOURA","SANTA LUZIA D OESTE","VILHENA","SAO MIGUEL DO GUAPORE",           "NOVA MAMORE","ALVORADA D OESTE","ALTO ALEGRE DOS PARECIS",
"ALTO PARAISO","BURITIS","NOVO HORIZONTE DO OESTE","CACAULANDIA","CAMPO NOVO DE RONDONIA","CANDEIAS DO JAMARI","CASTANHEIRAS",
"CHUPINGUAIA ","CUJUBIM","GOVERNADOR JORGE TEIXEIRA","ITAPUA DO OESTE","MINISTRO ANDREAZZA","MIRANTE DA SERRA",
"MONTE NEGRO","NOVA UNIAO","PARECIS","PIMENTEIRAS DO OESTE","PRIMAVERA DE RONDONIA","SAO FELIPE D OESTE ","SAO FRANCISCO DO GUAPORE ",
"SERINGUEIRAS ","TEIXEIROPOLIS","THEOBROMA ","URUPA","VALE DO ANARI","VALE DO PARAISO","ACORIZAL",
"AGUA BOA","ALTA FLORESTA","ALTO ARAGUAIA","ALTO BOA VISTA","ALTO GARCAS",
"ALTO PARAGUAI","ALTO TAQUARI"};

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

        listCidades = findViewById(R.id.listCidade);

        //Cria adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), //contexto
                android.R.layout.simple_list_item_1, //layout que será utilizado na lista
                android.R.id.text1, //campo do layout que será utilizado
                cidades //lista de nomes que será inserido no campo acima
                );

        //Add adaptador para lista
        listCidades.setAdapter(adaptador);

        //Pega posição na lista
        listCidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelected = listCidades.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "selecionado item: " + valorSelected, Toast.LENGTH_SHORT).show();
            }
        });
    }
}