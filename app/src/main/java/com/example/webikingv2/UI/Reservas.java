package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.webikingv2.R;
import com.example.webikingv2.ReservaCiclismo;
import com.example.webikingv2.ReservaEletrica;
import com.example.webikingv2.ReservaLocation;
import com.example.webikingv2.ReservaMontanha;

public class Reservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);
    }

    public void onClickReservaE(View V) {

        Intent intent = new Intent(getApplicationContext(), ReservaEletrica.class);
        startActivity(intent);
    }

    public void onClickReservaM(View V) {

        Intent intent = new Intent(getApplicationContext(), ReservaMontanha.class);
        startActivity(intent);
    }

    public void onClickReservaC(View V) {

        Intent intent = new Intent(getApplicationContext(), ReservaCiclismo.class);
        startActivity(intent);
    }


    public void onClickPonto(View V) {

        Intent intent = new Intent(getApplicationContext(), ReservaLocation.class);
        startActivity(intent);
    }
}