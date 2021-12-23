package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.webikingv2.R;


public class Escolha extends AppCompatActivity {

    private Button Escolher;
    private Button Criar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolha);
    }

    public void onClickEscolher(View V) {

        Intent intent = new Intent(getApplicationContext(), EscolherPercursos.class);
        startActivity(intent);
    }

    public void onClickFazer(View V) {

        Intent intent = new Intent(getApplicationContext(), FazerPercurso.class);
        startActivity(intent);
    }
}