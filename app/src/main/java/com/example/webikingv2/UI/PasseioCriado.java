package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.webikingv2.R;

public class PasseioCriado extends AppCompatActivity {


    private TextView descriada;
    private TextView origem1;
    private TextView destino1;
    private TextView nparticipantes1;
    private TextView data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeio_criado);


        Intent intent = getIntent();
        String origem = intent.getStringExtra("Origem");
        String destino = intent.getStringExtra("Destino");
        String organizador = intent.getStringExtra("Organizador");
        String data = intent.getStringExtra("Data");
        String descricao = intent.getStringExtra("Descricao");

        descriada = findViewById(R.id.descriada);
        descriada.setText(descricao);

        origem1 = findViewById(R.id.origemv2);
        origem1.setText(origem);

        destino1 = findViewById(R.id.destinov2);
        destino1.setText(destino);

       nparticipantes1 = findViewById(R.id.nparticipantes);
        nparticipantes1.setText(organizador);

        data1 = findViewById(R.id.data);
        data1.setText(data);




    }
}
