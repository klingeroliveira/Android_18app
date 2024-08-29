package com.example.calculadoradegorjeta;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editValorConta;
    private TextView textGorjetaPercent;
    private TextView textValorGorjeta;
    private TextView textValorTotal;
    private SeekBar seekBarGorjetaPercent;


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

        editValorConta = findViewById(R.id.textInputValorConta);
        textGorjetaPercent = findViewById(R.id.textGorjetaPercent);
        seekBarGorjetaPercent = findViewById(R.id.seekBarGorjetaPercent);
        textValorGorjeta = findViewById(R.id.textValorGorjeta);
        textValorTotal = findViewById(R.id.textValorTotal);

        seekBarGorjetaPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textGorjetaPercent.setText(progress + " %");

                calcularGorjeta(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcularGorjeta(int progress) {
        double valorGorjeta;
        double valorConta;
        double percent = progress;
        String valor = editValorConta.getText().toString();

        if (!TextUtils.isEmpty(valor)){
            valorConta = Double.parseDouble(valor);
            valorGorjeta = valorConta * (percent / 100);
            textValorGorjeta.setText("R$ " + String.format("%.2f", valorGorjeta));
            textValorTotal.setText("R$ " + String.format("%.2f", valorConta + valorGorjeta));
        } else {
            Toast.makeText(MainActivity.this, "Digite o valor da conta", Toast.LENGTH_SHORT).show();
        }
    }

}