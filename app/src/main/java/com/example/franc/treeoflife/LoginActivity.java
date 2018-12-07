package com.example.franc.treeoflife;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class LoginActivity extends Activity {

    TextView Username, Password;
    Button Login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
        progressBar.setVisibility(View.INVISIBLE);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    login();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void setupViews() {
        Username = findViewById(R.id.username_Login);
        Password = findViewById(R.id.password_Login);
        Login = findViewById(R.id.login_Login);
        progressBar=findViewById(R.id.progressBar);
    }

    private void login() throws InterruptedException {

        progressBar.setVisibility(View.VISIBLE);

        if (Username.getText().toString().toUpperCase().equals("MISSIONARIO") || Password.getText().toString().toUpperCase().equals("MISSIONARIO"))
        {
            Utente missionario = new Utente("Pino", "Mauro", "M");//M=missionario
            inviaUtente(missionario);
        }
        else if (Username.getText().toString().toUpperCase().equals("SOSTENITORE") || Password.getText().toString().toUpperCase().equals("SOSTENITORE"))
        {
            Utente sostenitore = new Utente("Claudio", "Cassese", "S");//S=sostenitore a distanza
            inviaUtente(sostenitore);
        }
        else if (Username.getText().toString().toUpperCase().equals("VOLONTARIO") || Password.getText().toString().toUpperCase().equals("VOLONTARIO"))
        {
            Utente volontario = new Utente("Francesco", "Napolitano", "V");//V=sostenitore volontario
            inviaUtente(volontario);
        }
    }

    private void inviaUtente(Utente utente) throws InterruptedException {
        Intent intent = new Intent(this, HomeActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("Utente",utente);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
