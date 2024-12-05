package com.example.projekt5566;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private Button dodaj;
    private Button usun;
    private TextView polubienia;
    int x;

    private EditText email;
    private EditText haslo1;
    private EditText haslo2;
    private Button przeslij;
    private Button zobacz;
    private TextView komunikat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = 0;
        dodaj = findViewById(R.id.dodaj);
        usun = findViewById(R.id.usun);
        polubienia = findViewById(R.id.polubienia);

        email = findViewById(R.id.email);
        haslo1 = findViewById(R.id.editTextTextPassword2);
        haslo2 = findViewById(R.id.editTextTextPassword3);
        przeslij = findViewById(R.id.przeslij);
        komunikat = findViewById(R.id.textView4);
        zobacz = findViewById(R.id.zobacz);

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zwieksz();
            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zmniejsz();
            }
        });

        przeslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!haslo1.getText().toString().equals(haslo2.getText().toString())){
                    komunikat.setText("hasła sie nie zgadzają");
                } else if(email.getText().toString().contains("@") == false) {
                    komunikat.setText("Mail sie nie zgadza");
                } else {
                    komunikat.setText("Zarejestrowano: " + email.getText().toString());
                }
            }
        });

        zobacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                komunikat.setText(email.getText().toString());
            }
        });


    }

    public void zwieksz(){
        x++;
        polubienia.setText(x + " polubień");
    }

    public void zmniejsz(){
        x--;
        if(x<0){
            x = 0;
        }
        polubienia.setText(x + " polubień");
    }
}