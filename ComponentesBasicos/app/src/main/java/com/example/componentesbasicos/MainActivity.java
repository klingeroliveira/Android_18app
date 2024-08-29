package com.example.componentesbasicos;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView textoResultado;

    private CheckBox checkVerde, checkBranco, checkVermelho;
    private RadioButton radioButtonMasculino, radioButtonFeminino;
    private RadioGroup radioGroupSexo;

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

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);
        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho= findViewById(R.id.checkVermelho);
        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
        radioButtonFeminino = findViewById(R.id.radioButtonFeminino);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);

        checkedSexo();
    }


    public void enviar(View view){
        String texto = getCores();

        texto += getSexo();

        campoNome = findViewById(R.id.editNome);
        campoEmail = findViewById(R.id.editEmail);
        textoResultado = findViewById(R.id.textResultado);

        textoResultado.setText(texto + " Nome: " + campoNome.getText() + " Email: " + campoEmail.getText());
    }

    private String getCores() {
        String texto = "";

        if (checkVerde.isChecked()) {
            texto = checkVerde.getText().toString() + " selecionado - ";
        }
        if (checkBranco.isChecked()) {
            texto = texto + checkBranco.getText().toString() + " selecionado - ";
        }
        if (checkVermelho.isChecked()) {
            texto = texto + checkVermelho.getText().toString() + " selecionado - ";
        }
        return texto;
    }

    private String getSexo(){
        String texto = "";

        if (radioButtonMasculino.isChecked()){
            texto = radioButtonMasculino.getText().toString() + " selecionado - ";
        } else if (radioButtonFeminino.isChecked()) {
            texto = radioButtonFeminino.getText().toString() + " selecionado - ";
        }
        return texto;
    }

    private void checkedSexo(){
        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (id == radioButtonMasculino.getId()){
                    textoResultado.setText(radioButtonMasculino.getText().toString() + " selecionado ");
                } else if (id == radioButtonFeminino.getId()) {
                    textoResultado.setText(radioButtonFeminino.getText().toString() + " selecionado ");
                }
            }
        });
    }
}