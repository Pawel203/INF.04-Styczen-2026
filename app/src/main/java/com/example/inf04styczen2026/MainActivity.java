package com.example.inf04styczen2026;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView obrazek;
    RadioButton radio1, radio2, radio3;
    TextView pytanie;
    int[] zdjecia = {
            R.drawable.zad1,
            R.drawable.zad2,
            R.drawable.zad3
    };
    int obecneZdjecie = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        obrazek = findViewById(R.id.obrazek);
        pytanie = findViewById(R.id.pytanie);
        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);


    }
    public void dalej(View view) {
        if (obecneZdjecie>2){
            obecneZdjecie = 0;
        }
        else {
            obecneZdjecie = 0;
        }
        obrazek.setImageResource(zdjecia[obecneZdjecie]);
    }
}