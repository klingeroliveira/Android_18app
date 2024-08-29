package com.example.alcoolougasolina;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

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

        editPrecoAlcool = findViewById(R.id.textPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.textPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void CalcularOpcao (View view){

        Double precoAlcool = Double.valueOf(
                    TextUtils.isEmpty(String.valueOf(editPrecoAlcool.getText())) ? "0.0" : String.valueOf(editPrecoAlcool.getText())
        );
        Double precoGasolina = Double.valueOf(
                TextUtils.isEmpty(String.valueOf(editPrecoGasolina.getText())) ? "0.0" : String.valueOf(editPrecoGasolina.getText())
        );

        if (!isEmpty(precoAlcool) && !isEmpty(precoGasolina)){
            textResultado.setText( (precoAlcool / precoGasolina) >= 0.7 ? "Melhor utilizar gasolina!" : "Melhor utilizar alcool!");
        } else {
            textResultado.setText("Os campos não podem estar vazios ou com valor zero!");
        }

    }

    public static boolean isEmpty(Double value) {
        return value == null || value == 0.0;
    }
}