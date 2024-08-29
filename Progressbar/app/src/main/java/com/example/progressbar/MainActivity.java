package com.example.progressbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBarHorizontal;
    private ProgressBar progressBarCircular;
    private Button bntCarregar;
    private int progress = 0;


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

        progressBarHorizontal = findViewById(R.id.progressBarHorizontal);
        progressBarCircular = findViewById(R.id.progressBarCircular);
        bntCarregar = findViewById(R.id.button);
        progressBarCircular.setVisibility(View.GONE);
    }

    public void carregar(View view){
        progress += 1;
        if (progress < 11){
            progressBarHorizontal.setProgress(progress);

            progressBarCircular.setVisibility(View.VISIBLE);

            if(progress == 10){
                progressBarCircular.setVisibility(View.GONE);
                bntCarregar.setEnabled(false);
            }
        } 
    }

    public void recomecar(View view){
        progress = 0;
        progressBarHorizontal.setProgress(0);
        progressBarCircular.setVisibility(View.GONE);
        bntCarregar.setEnabled(true);
    }

}