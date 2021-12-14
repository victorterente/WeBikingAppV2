package com.example.webikingv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class SignIn extends AppCompatActivity {

    private Button Login;
    private EditText Email;
    private EditText Pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Pass = (EditText) findViewById(R.id.pass);
        Email = (EditText) findViewById(R.id.etemail);
        Login = (Button) findViewById(R.id.SignIn);
    }


    private void validate(String userName, String userPassword){



    }
    public void onClickSignIn(View V) {

        Intent intent = new Intent(getApplicationContext(),Escolha.class);
        startActivity(intent);
    }

}