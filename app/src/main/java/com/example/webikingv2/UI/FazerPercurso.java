package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.webikingv2.Downloaders.PostData;
import com.example.webikingv2.R;


import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class FazerPercurso extends AppCompatActivity {
    private Button criar;
    private EditText origem, data;
    private EditText destino;
    private EditText nparticipantes;
    private EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fazer_percurso);

        origem = (EditText)  findViewById(R.id.origemv2);
        destino = (EditText)  findViewById(R.id.destino);
        nparticipantes = (EditText)findViewById(R.id.nparticipantes);
        descricao = (EditText)  findViewById(R.id.descricao);
        criar = (Button) findViewById(R.id.criar);
        data = (EditText) findViewById(R.id.data);


        origem.setText("Sintra");
        destino.setText("Montelavar");
        nparticipantes.setText("7");
        data.setText("2022-01-11");
        descricao.setText("Passeio calmo por sintra");

        criar.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
            try {


                if (origem.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                    origem.setHintTextColor(Color.RED);
                }
                if (destino.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                    destino.setHintTextColor(Color.RED);
                }
                if (nparticipantes.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                    nparticipantes.setHintTextColor(Color.RED);
                }
                if (descricao.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                    descricao.setHintTextColor(Color.RED);
                }

                if (data.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                    data.setHintTextColor(Color.RED);
                }


                else {
                    Map<String, String> postData = new HashMap<>();
                    //verificar os inputs,adicionar a data
                    postData.put("origem", origem.getText().toString());
                    postData.put("destino", destino.getText().toString());
                    postData.put("organizador", nparticipantes.getText().toString());
                    postData.put("descricao", descricao.getText().toString());
                    postData.put("data", data.getText().toString());
                    JSONArray arr;
                    PostData task = new PostData(postData);
                    //verificar o link
                    arr = task.execute("https://webiking-db.herokuapp.com/api/evento/new").get();

                    Toast.makeText(getApplicationContext(), "Percurso criado !", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(getApplicationContext(), PasseioCriado.class);

                    startActivity(intent);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
    });

}
}


