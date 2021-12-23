package com.example.webikingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.webikingv2.Downloaders.PostData;
import com.example.webikingv2.UI.EscolherPercursos;
import com.example.webikingv2.UI.PasseioCriado;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class PasseioCascais extends AppCompatActivity {

    private Button inscrever;
    private EditText eventoid,utilizadorid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passeio_cascais);

        eventoid = (EditText)  findViewById(R.id.eventoid);
        utilizadorid = (EditText)  findViewById(R.id.utilizadorid);
        inscrever = (Button) findViewById(R.id.inscrever);
        inscrever.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                try {


                    if (eventoid.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        eventoid.setHintTextColor(Color.RED);
                    }
                    if (utilizadorid.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        utilizadorid.setHintTextColor(Color.RED);
                    }



                    else {
                        Map<String, String> postData = new HashMap<>();
                        //verificar os inputs,adicionar a data
                        postData.put("eventoid", eventoid.getText().toString());
                        postData.put("utilizadorid", utilizadorid.getText().toString());

                        JSONArray arr;
                        PostData task = new PostData(postData);
                        //verificar o link
                        arr = task.execute("https://webiking-db.herokuapp.com/api/participante/new").get();

                        Toast.makeText(getApplicationContext(), "Inscrição com sucesso !", Toast.LENGTH_SHORT).show();


                        Intent intent = new Intent(getApplicationContext(), EscolherPercursos.class);

                        startActivity(intent);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}