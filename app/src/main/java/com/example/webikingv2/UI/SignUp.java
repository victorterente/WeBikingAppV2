package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.webikingv2.LoginDetails.LoginDataSource;
import com.example.webikingv2.Downloaders.PostData;
import com.example.webikingv2.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    private Button registar;
    private EditText email;
    private EditText pass;
    private Spinner genero;
    private EditText telemovel;
    private EditText dtnasc;
    private EditText nome;

    String postBDate;
    ArrayList<String> listGender;
    ArrayAdapter<String> adapterGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        nome = findViewById(R.id.nome);
        email = findViewById(R.id.email);
        dtnasc = findViewById(R.id.dtnasc);
        pass = findViewById(R.id.pass);
        genero = findViewById(R.id.genero);
        telemovel = findViewById(R.id.telemovel);
        registar = findViewById(R.id.SignUp);
        listGender = new ArrayList<>();




        listGender.add("M");
        listGender.add("F");


        adapterGender = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listGender);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genero.setAdapter(adapterGender);
        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    if (nome.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        nome.setHintTextColor(Color.RED);
                    }
                    if (telemovel.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        telemovel.setHintTextColor(Color.RED);
                    }
                    if (dtnasc.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        dtnasc.setHintTextColor(Color.RED);
                    }
                    if (pass.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        pass.setHintTextColor(Color.RED);
                    }
                    if (email.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Favor preencher o campo em vermelho", Toast.LENGTH_SHORT).show();
                        email.setHintTextColor(Color.RED);
                    }
                    else {
                        Map<String, String> postData = new HashMap<>();
       //verificar os inputs
                        postData.put("nome", nome.getText().toString());
                        postData.put("dtnasc", dtnasc.getText().toString());
                        postData.put("genero", "M");
                        postData.put("email", email.getText().toString());
                        postData.put("pass", pass.getText().toString());
                        postData.put("telemovel", telemovel.getText().toString());
                        JSONArray arr;
                        PostData task = new PostData(postData);
                        //verificar o link
                        arr = task.execute("https://webiking-db.herokuapp.com/api/utilizador/new").get();

                        Toast.makeText(getApplicationContext(), "Welcome !"+ nome.getText().toString(), Toast.LENGTH_SHORT).show();


                      //  LoginDataSource login = new LoginDataSource();
                        //login.login(""+email.getText().toString(), ""+pass.getText().toString());
                        Log.e("Id Sign up activity", ""+LoginDataSource.ID);
                        startActivity(new Intent(SignUp.this, SignIn.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        });

    }

}


