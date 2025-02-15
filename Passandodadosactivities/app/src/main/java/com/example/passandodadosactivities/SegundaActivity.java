package com.example.passandodadosactivities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.passandodadosactivities.model.Usuario;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade, textUsuario, textEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);
        textUsuario = findViewById(R.id.textUsuario);
        textEmail = findViewById(R.id.textEmail);

        Bundle bundle = getIntent().getExtras();
        //o objeto é recuperado (getSerializable) no mesmo tipo que foi enviado
        Usuario usuario = (Usuario) bundle.getSerializable("usuario");

        textNome.setText(bundle.getString("nome"));
        textIdade.setText(String.valueOf(bundle.getInt("idade")));
        textUsuario.setText(usuario.getNome());
        textEmail.setText(usuario.getEmail());

    }
}