package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    Utente utente;
    Button HomePage, LavoraConNoi, AdottaOra;
    TextView Contatti, Aiuto, Faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupView();

        getUtente();

        Toast.makeText(HomeActivity.this, "Benvenuto, "+utente.getNome()+" "+utente.getCognome()+".", Toast.LENGTH_LONG).show();

        }

    private void setupView() {
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Contatti = findViewById(R.id.contatti_Home);
        Aiuto = findViewById(R.id.aiuto_Home);
        Faq = findViewById(R.id.faq_Home);
    }

        private void getUtente(){
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if(extras!=null)
                utente = (Utente) extras.getSerializable("Utente");
        }
    }

