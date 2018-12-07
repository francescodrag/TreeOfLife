package com.example.franc.treeoflife;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AreaActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra;
    ImageView Area, Logo;
    Utente utente;
    TextView Nome, Cognome;
    Button button;

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
        checkButton(utente);

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AreaActivity.this, LavoraConNoiActivity.class));
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AreaActivity.this, AdottaOraActivity.class));
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AreaActivity.this, HomeActivity.class));
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AreaActivity.this, HomeActivity.class));
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkButton(Utente utente){
        if(utente.getTipo().equals("M")){
            button.setText("Richiedi fondi");
            button.setTextSize(25);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(AreaActivity.this, RichiediFondiActivity.class));
                }
            });
        }else{
            button.setText("Le Mie Adozioni Attive");
            button.setTextSize(25);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(AreaActivity.this,LeMieAdozioniActivity.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void setupView(){
        Nome = findViewById(R.id.nome_Area);
        Cognome = findViewById(R.id.cognome_Area);
        button = findViewById(R.id.Button_Area);
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

}
