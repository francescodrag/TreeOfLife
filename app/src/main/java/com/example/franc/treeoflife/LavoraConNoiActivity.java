package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LavoraConNoiActivity extends Activity {

    Button HomePage, DiventaVolontario, AdottaOra;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavora_con_noi);

        setupView();
        getUtente();

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LavoraConNoiActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(LavoraConNoiActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LavoraConNoiActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(LavoraConNoiActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        DiventaVolontario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setupView() {
        HomePage = findViewById(R.id.home_LavoraConNoi);
        DiventaVolontario = findViewById(R.id.diventaVolontario_LavoraConNoi);
        AdottaOra = findViewById(R.id.adotta_LavoraConNoi);
        Area = findViewById(R.id.area_LavoraConNoi);
        Logo = findViewById(R.id.logo_LavoraConNoi);
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
