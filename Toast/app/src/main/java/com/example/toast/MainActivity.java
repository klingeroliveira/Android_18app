package com.example.toast;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    public void abrirToast(View view){
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(android.R.drawable.star_big_on);

        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(com.google.android.material.R.color.design_default_color_secondary);
        textView.setText("Text toast custom");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        //toast.setView(imageView);
        toast.setView(textView);
        toast.show();

        /*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso!",
                Toast.LENGTH_LONG
        ).show();
        */
    }
}