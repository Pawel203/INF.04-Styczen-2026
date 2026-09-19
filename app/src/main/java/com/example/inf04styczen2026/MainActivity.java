package com.example.inf04styczen2026;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    ImageView obrazek;
    RadioButton radio1, radio2, radio3;
    TextView pytanie;
    RadioGroup odpowiedz;
    int[] zdjecia = {
            R.drawable.zad1,
            R.drawable.zad2,
            R.drawable.zad3
    };
    String[] pytania = {
            "Które to schronisko?",
            "Zwierzę na zdjęciu to",
            "W oddali są widoczne"
    };
    int[] poprawneOdpowiedzi = {
            R.id.radio2,
            R.id.radio1,
            R.id.radio3
    };
    String[] odpowiedzi = {
            "Na Rysiance.",
            "Na Wielkiej Raczy.",
            "Na Wielkiej Rycerzowej.",
            "owczarek.",
            "wilk.",
            "kozica.",
            "Himalaje.",
            "Alpy.",
            "Tatry."
    };
    int indexOdpowiedzi = 0;
    int indexPytania = 0;
    int wybranaOdpowiedz;
    int liczbaPunktow = 0;
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
        odpowiedz = findViewById(R.id.odpowiedz);


    }
    public void dalej(View view) {
        if (indexPytania == 2){
            indexPytania = 0;
            indexOdpowiedzi = 0;
        }

        wybranaOdpowiedz = odpowiedz.getCheckedRadioButtonId();
        if (wybranaOdpowiedz == poprawneOdpowiedzi[indexPytania]){
            liczbaPunktow++;
            indexOdpowiedzi +=3;
            indexPytania ++;
            obrazek.setImageResource(zdjecia[indexPytania]);
            if (zdjecia[indexPytania] == R.drawable.zad2){
                obrazek.setRotation(90f);
            } else {
                obrazek.setRotation(0f);
            }
            pytanie.setText(pytania[indexPytania]);
            radio1.setText((odpowiedzi[indexOdpowiedzi]));
            radio2.setText((odpowiedzi[indexOdpowiedzi+1]));
            radio3.setText((odpowiedzi[indexOdpowiedzi+2]));
        }

        else {
            indexPytania = 0;
            indexOdpowiedzi = 0;
            obrazek.setImageResource(zdjecia[indexPytania]);
            if (zdjecia[indexPytania] == R.drawable.zad2){
                obrazek.setRotation(90f);
            } else {
                obrazek.setRotation(0f);
            }
            pytanie.setText(pytania[indexPytania]);
            radio1.setText((odpowiedzi[indexOdpowiedzi]));
            radio2.setText((odpowiedzi[indexOdpowiedzi+1]));
            radio3.setText((odpowiedzi[indexOdpowiedzi+2]));
        }
        odpowiedz.clearCheck();
    }
}