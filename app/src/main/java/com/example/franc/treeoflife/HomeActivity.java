package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    Utente utente;
    Button HomePage, LavoraConNoi, AdottaOra;
    ImageView Area, Logo;
    TextView Contatti;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupView();
        getUtente();



        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        Contatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(HomeActivity.this,ContattiActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        }


    private void setupView() {
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Contatti = findViewById(R.id.contatti_Home);
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

