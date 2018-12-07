package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AreaActivity extends Activity {

    Utente utente;
    TextView Nome, Cognome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        getUtente();
        setupView();

        Nome.setText(utente.getNome());
        Nome.setTextSize(25);
        Cognome.setText(utente.getCognome());
        Cognome.setTextSize(25);
        //Toast.makeText(AreaActivity.this, "Benvenuto, "+utente.getNome()+" "+utente.getCognome()+".", Toast.LENGTH_LONG).show();

    }

    private void setupView(){
        Nome = findViewById(R.id.nome_Area);
        Cognome = findViewById(R.id.cognome_Area);
    }

    private void getUtente(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null)
            utente = (Utente) extras.getSerializable("Utente");
    }
}
