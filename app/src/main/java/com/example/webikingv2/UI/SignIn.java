package com.example.webikingv2.UI;

import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


import com.example.webikingv2.Downloaders.JSONArrayDownloader;
import com.example.webikingv2.R;

import java.util.concurrent.ExecutionException;

public class SignIn extends AppCompatActivity {

    private Button login;
    private EditText email;
    private EditText password;
    private JSONArray LoginCredentials = null;
    public static String USER_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        password = (EditText) findViewById(R.id.pass);
        email = (EditText) findViewById(R.id.email);
        login = (Button) findViewById(R.id.SignIn);

        email.setText("ana@sapo.pt");
        password.setText("jhh2jde");


        JSONArrayDownloader task2 = new JSONArrayDownloader();
        LoginCredentials = new JSONArray();
        try {
            LoginCredentials = task2.execute("https://webiking-db.herokuapp.com/api/utilizador").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.e("credentuals:" , ""+ LoginCredentials) ;

    }
    public void onClickLogin(View v) throws JSONException {

        JSONArray test = new JSONArray();
        String Email = email.getText().toString();
        String Password = password.getText().toString();



        JSONObject utilizador;
        //vamos verificar se dentro do array existem as strings que o utilizador inseriu
        for (int i = 0; i < LoginCredentials.length(); i++) {
            utilizador= LoginCredentials.getJSONObject(i);


            if (utilizador.getString("email").equals(Email) && utilizador.getString("pass").equals(Password)) {

                USER_ID = utilizador.getString("utilizadorid");

                Intent intent = new Intent(getApplicationContext(), Escolha.class);
                startActivity(intent);
                Log.e(String.valueOf(this), LoginCredentials.get(i).toString());

            } else if (utilizador.getString("email").isEmpty() && utilizador.getString("pass").isEmpty()) {
                Toast.makeText(this, "Credenciais erradas!!! Verifique se está tudo bem!!!", Toast.LENGTH_SHORT).show();
            }else if (utilizador.getString("email").isEmpty()){
                Toast.makeText(this, "Credenciais erradas!!! Verifique se está tudo bem!!!", Toast.LENGTH_SHORT).show();
            }else if (utilizador.getString("pass").isEmpty()){
                Toast.makeText(this, "Credenciais erradas!!! Verifique se está tudo bem!!!", Toast.LENGTH_SHORT).show();
            }else if (Email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(this, "Credenciais erradas!!! Verifique se está tudo bem!!!", Toast.LENGTH_SHORT).show();
            }

        }



    }

}
