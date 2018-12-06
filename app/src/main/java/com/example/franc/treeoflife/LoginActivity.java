package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class LoginActivity extends Activity {

    TextView Username, Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void setupViews() {
        Username = findViewById(R.id.username_Login);
        Password = findViewById(R.id.password_Login);
        Login = findViewById(R.id.login_Login);
    }

    private void login() {
        if (Username.getText().toString().toUpperCase().equals("MISSIONARIO") || Password.getText().toString().toUpperCase().equals("MISSIONARIO"))
        {
            Utente missionario = new Utente("Pino", "Mauro", "M");//M=missionario
            Intent intent = new Intent(this, HomeActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("Utente",missionario);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else if (Username.getText().toString().toUpperCase().equals("SOSTENITORE") || Password.getText().toString().toUpperCase().equals("SOSTENITORE"))
        {
            Utente sostenitore = new Utente("Claudio", "Cassese", "S");//S=sostenitore a distanza
            Intent intent = new Intent(this, HomeActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("Utente",sostenitore);
            intent.putExtras(extras);
            startActivity(intent);
        }
        else if (Username.getText().toString().toUpperCase().equals("VOLONTARIO") || Password.getText().toString().toUpperCase().equals("VOLONTARIO"))
        {
            Utente volontario = new Utente("Francesco", "Napolitano", "V");//V=sostenitore volontario
            Intent intent = new Intent(this, HomeActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("Utente",volontario);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}
