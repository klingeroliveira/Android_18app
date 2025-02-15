package com.example.passandodadosactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passandodadosactivities.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private Button buttonActivity;

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

        buttonActivity = findViewById(R.id.buttonActivity);

        buttonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                Usuario usuario = new Usuario("Klinger", "klinger@hotmail.com");

                intent.putExtra("nome", "Sara");
                intent.putExtra("idade", 42);

                //Classe usuario implementa a interface Serializable, o objeto é transformado em bytes
                intent.putExtra("usuario", usuario);

                startActivity(intent);
            }
        });
    }
}