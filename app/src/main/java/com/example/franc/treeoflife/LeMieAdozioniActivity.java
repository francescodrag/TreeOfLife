package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LeMieAdozioniActivity extends Activity {
    Button inviaDoni, organizzaIncontro, HomePage, LavoraConNoi, AdottaOra;
    ImageView Area, Logo;
    Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_adozioni);
        getUtente();
        setupViews();
        inviaDoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        organizzaIncontro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inviaUtente(utente);
            }
        });

    }

    private void setupViews() {
        inviaDoni = findViewById(R.id.InviaDoni_Adozione);
        organizzaIncontro = findViewById(R.id.OrganizzaIncontro_Adozioni);
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Area = findViewById(R.id.area_Home);
        Logo = findViewById(R.id.logo_Home);

    }

    private void inviaUtente(Utente utente) {
        Intent intent = new Intent(LeMieAdozioniActivity.this, AreaActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("Utente",utente);
        intent.putExtras(extras);
        startActivity(intent);
    }
    private void getUtente(){
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null)
            utente = (Utente) extras.getSerializable("Utente");
    }
}
