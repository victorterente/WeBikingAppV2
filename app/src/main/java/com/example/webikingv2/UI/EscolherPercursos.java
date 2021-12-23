package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.webikingv2.PasseioCascais;
import com.example.webikingv2.PasseioSintra;
import com.example.webikingv2.R;

public class EscolherPercursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_percursos);
    }
    public void onClickS(View V) {

        Intent intent = new Intent(getApplicationContext(), PasseioSintra.class);
        startActivity(intent);
    }
    public void onClickC(View V) {

        Intent intent = new Intent(getApplicationContext(), PasseioCascais.class);
        startActivity(intent);
    }

    public void onClickR(View V) {

        Intent intent = new Intent(getApplicationContext(), Reservas.class);
        startActivity(intent);
    }

}