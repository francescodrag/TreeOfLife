package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ContattiActivity extends Activity {
    Button HomePage, LavoraConNoi, AdottaOra;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatti);
        setupView();
        getUtente();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ContattiActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ContattiActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });


        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ContattiActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ContattiActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });
    }

    private void setupView() {
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Area = findViewById(R.id.area_Home);
        Logo = findViewById(R.id.logo_Home);
    }
    private void getUtente(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null)
            utente = (Utente) extras.getSerializable("Utente");
    }
    private void inviaUtente(Utente utente) {
        Bundle extras = new Bundle();
        extras.putSerializable("Utente",utente);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
