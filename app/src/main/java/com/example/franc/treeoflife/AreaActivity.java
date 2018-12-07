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

    Button HomePage, LavoraConNoi, AdottaOra, Logout;
    ImageView Area, Logo;
    Utente utente;
    TextView Nome, Cognome;
    Button button;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        setupView();
        getUtente();


        Nome.setText(utente.getNome());
        Nome.setTextSize(25);
        Cognome.setText(utente.getCognome());
        Cognome.setTextSize(25);
        checkButton(utente.getTipo());

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AreaActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AreaActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               intent=new Intent(AreaActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AreaActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AreaActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkButton(String tipo){
        if(tipo.equals("M")){
            button.setText("Richiedi fondi");
            button.setTextSize(25);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent=new Intent(AreaActivity.this, RichiediFondiActivity.class);
                    inviaUtente(utente);
                }
            });
        }else{
            button.setText("Le Mie Adozioni Attive");
            button.setTextSize(25);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent=new Intent(AreaActivity.this,LeMieAdozioniActivity.class);
                    inviaUtente(utente);
                }
            });

        }

    }

    private void setupView(){
        Nome = findViewById(R.id.nome_Area);
        Cognome = findViewById(R.id.cognome_Area);
        button = findViewById(R.id.Area_button);
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Area = findViewById(R.id.area_Home);
        Logo = findViewById(R.id.logo_Home);
        Logout=findViewById(R.id.Logout_Area);
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
