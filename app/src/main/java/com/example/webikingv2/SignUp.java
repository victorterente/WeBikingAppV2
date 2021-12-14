package com.example.webikingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignUp extends AppCompatActivity {

    private Button registar;
    private EditText email;
    private EditText pass;
    private EditText genero;
    private EditText telemovel;
    private EditText dtnasc;
    private EditText nome;
    private ImageButton voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onClickSignup(View V) {

        Intent intent = new Intent(getApplicationContext(),SignIn.class);
        startActivity(intent);
    }
}