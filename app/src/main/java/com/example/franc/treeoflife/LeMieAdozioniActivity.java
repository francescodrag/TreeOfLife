package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LeMieAdozioniActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra, OrganizzaIncontro, InviaDoni;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_adozioni);

        setupView();
        getUtente();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        InviaDoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, InviaDoniActivity.class);
                inviaUtente(utente);
            }
        });

        OrganizzaIncontro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LeMieAdozioniActivity.this, OrganizzaIncontroActivity.class);
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
        OrganizzaIncontro=findViewById(R.id.OrganizzaIncontro_Adozioni);
        InviaDoni=findViewById(R.id.InviaDoni_Adozione);
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
