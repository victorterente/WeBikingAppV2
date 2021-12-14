package com.example.webikingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FazerPercurso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_percurso);
    }
    public void onClickCriar(View V) {

        Intent intent = new Intent(getApplicationContext(),ReservaLocation.class);
        startActivity(intent);
    }
}
