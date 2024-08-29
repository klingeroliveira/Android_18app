package com.example.togglebuttonswitch;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Switch switchSenha;
    private ToggleButton toggleSenha;
    private TextView textResultado;
    private CheckBox checkSenha;

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

        switchSenha = findViewById(R.id.switchSenha);
        toggleSenha = findViewById(R.id.toggleButton);
        checkSenha = findViewById(R.id.checkSenha);
        textResultado = findViewById(R.id.textResultado);

        CriarListener();
    }

    public void CriarListener (){
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                textResultado.setText("switchSenha: " + (isChecked ? switchSenha.getTextOn() : switchSenha.getTextOff()));
            }
        });

        toggleSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                textResultado.setText("toggleSenha: " + (isChecked ? toggleSenha.getTextOn() : toggleSenha.getTextOff()));
            }
        });

        checkSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                textResultado.setText("checkSenha: " + (isChecked ? "Ligado" : "Desligado"));
            }
        });
    }

    public void Resultado (View view){
        textResultado.setText("switchSenha: " + (switchSenha.isChecked() ? switchSenha.getTextOn() : switchSenha.getTextOff()));
    }
}