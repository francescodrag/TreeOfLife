package com.example.franc.treeoflife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class LoginActivity extends Activity {
    ArrayList<Utente> utenti;
    TextView Username, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();

    }

    private void setupViews(){
        Username = findViewById(R.id.username_Login);
        Password = findViewById(R.id.password_Login);
        Login = findViewById(R.id.login_Login);
    }

    private void login(){
        if(Username.getText().toString().toUpperCase().equals("MISSIONARIO") || Password.getText().toString().toUpperCase().equals("MISSIONARIO")){

        }
    }
}
