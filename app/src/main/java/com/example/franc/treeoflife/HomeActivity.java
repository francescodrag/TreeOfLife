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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupView();
        getUtente();

        Toast.makeText(HomeActivity.this, "Benvenuto, "+utente.getNome()+" "+utente.getCognome()+".", Toast.LENGTH_LONG).show();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LavoraConNoiActivity.class));
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AdottaOraActivity.class));
            }
        });

        Contatti.setOnClickListener(new View.OnClickListener() {
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
        Intent intent = new Intent(HomeActivity.this, AreaActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("Utente",utente);
        intent.putExtras(extras);
        startActivity(intent);
    }
}

