package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

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
    }

    public void pedraSelecionada(View view) {
        opcaoSelecionada(Opcao.PEDRA.nome);
    }
    public void papelSelecionada(View view) {
        opcaoSelecionada(Opcao.PAPEL.nome);
    }
    public void tesouraSelecionada(View view) {
        opcaoSelecionada(Opcao.TESOURA.nome);
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        int numeroApp = new Random().nextInt(3);
        String escolhaApp = Opcao.getOpcaoById(numeroApp).nome;
        ImageView imgEscolhaApp = findViewById(R.id.imgEscolhaApp);

        TextView textResultado = findViewById(R.id.textResultado);

        if (escolhaApp.equals(Opcao.PEDRA.nome)) {
            imgEscolhaApp.setImageResource(R.drawable.pedra);
        } else if (escolhaApp.equals(Opcao.PAPEL.nome)) {
            imgEscolhaApp.setImageResource(R.drawable.papel);
        } else {
            imgEscolhaApp.setImageResource(R.drawable.tesoura);
        }

        System.out.println("App: " + escolhaApp);
        System.out.println("Usuario: " + escolhaUsuario);

           /*
    pedra < papel
    papel < tesoura
    tesoura < pedra
*/
        switch (escolhaApp){
            case "pedra":
                if (escolhaUsuario == Opcao.PEDRA.nome){
                    textResultado.setText(R.string.empate);
                } else if (escolhaUsuario == Opcao.PAPEL.nome) {
                    textResultado.setText(R.string.ganhou);
                } else if (escolhaUsuario == Opcao.TESOURA.nome) {
                    textResultado.setText(R.string.perdeu);
                }
                break;
            case "tesoura":
                if (escolhaUsuario == Opcao.PEDRA.nome){
                    textResultado.setText(R.string.ganhou);
                } else if (escolhaUsuario == Opcao.PAPEL.nome) {
                    textResultado.setText(R.string.perdeu);
                } else if (escolhaUsuario == Opcao.TESOURA.nome) {
                    textResultado.setText(R.string.empate);
                }
                break;
            case "papel":
                if (escolhaUsuario == Opcao.PEDRA.nome){
                    textResultado.setText(R.string.perdeu);
                } else if (escolhaUsuario == Opcao.PAPEL.nome) {
                    textResultado.setText(R.string.empate);
                } else if (escolhaUsuario == Opcao.TESOURA.nome) {
                    textResultado.setText(R.string.ganhou);
                }
                break;
        }

    }

    public enum Opcao {

        PEDRA(0, "pedra"),
        PAPEL(1, "papel"),
        TESOURA(2, "tesoura");

        private int id;
        private String nome;

        Opcao(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        public static Opcao getOpcaoById(int id){
            switch (id){
                case 0 : return PEDRA;
                case 1 : return PAPEL;
                case 2 : return TESOURA;
            }
            return null;
        }
    }
}
