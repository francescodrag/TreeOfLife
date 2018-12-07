package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InviaDoniActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra, InviaDoni;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invia_doni);

        setupView();
        getUtente();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        InviaDoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, AdottaOraActivity.class));
            }
        });
    }

    private void setupView() {
        HomePage = findViewById(R.id.home_InviaDoni);
        LavoraConNoi = findViewById(R.id.lavora_InviaDoni);
        InviaDoni = findViewById(R.id.inviaDono_InviaDoni);
        Area = findViewById(R.id.area_InviaDoni);
        Logo = findViewById(R.id.logo_InviaDoni);
        AdottaOra = findViewById(R.id.adotta_InviaDoni);
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
