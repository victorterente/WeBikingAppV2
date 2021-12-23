package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.webikingv2.R;

public class PaginaInicial extends AppCompatActivity {


    private static String ip = "ec2-18-202-1-222.eu-west-1.compute.amazonaws.com";// this is the host ip that your data base exists on you can use 10.0.2.2 for local host                                                    found on your pc. use if config for windows to find the ip if the database exists on                                                    your pc
    private static String port = "5432";// the port sql server runs on
    private static String Classes ="heroku pg:psql postgresql-elliptical-59131 --app webiking-db";// the driver that is required for this connection use                                                                           "org.postgresql.Driver" for connecting to postgresql
    private static String database = "df8fats5leofdk";// the data base name
    private static String username = "jhxblwegfaxegd";// the user name
    private static String password = "c47b8396a56df69df86ee29dbefccced790cd7d4f4eb21d536ac5cc06c31a1a1";// the password
    private static String url = "postgres://jhxblwegfaxegd:c47b8396a56df69df86ee29dbefccced790cd7d4f4eb21d536ac5cc06c31a1a1@ec2-18-202-1-222.eu-west-1.compute.amazonaws.com:5432/df8fats5leofdk";



    private Button SignIn;
    private Button SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicial);
    }

    public void onClickSignUp(View V) {

        Intent intent = new Intent(getApplicationContext(), com.example.webikingv2.UI.SignUp.class);
        startActivity(intent);
    }

    public void onClickSignIn(View V) {

        Intent intent = new Intent(getApplicationContext(), com.example.webikingv2.UI.SignIn.class);
        startActivity(intent);
    }
}