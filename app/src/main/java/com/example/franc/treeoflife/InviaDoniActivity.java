package com.example.franc.treeoflife;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InviaDoniActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra, InviaDoni;
    TextView Colli, Peso, Altezza, Larghezza,Data, Biglietto;
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
                String colli = Colli.getText().toString();
                String peso = Peso.getText().toString();
                String altezza = Altezza.getText().toString();
                String larghezza = Larghezza.getText().toString();
                String data = Data.getText().toString();
                String biglietto = Biglietto.getText().toString();
                if(colli.equals("")||peso.equals("")||altezza.equals("")||larghezza.equals("")||data.equals("")||biglietto.equals(""))
                    Toast.makeText(InviaDoniActivity.this, "Compila tutti i campi, per favore.", Toast.LENGTH_SHORT).show();
                else
                    allert();
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(InviaDoniActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
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
        Colli = findViewById(R.id.colli_InviaDoni);
        Peso = findViewById(R.id.peso_InviaDoni);
        Altezza = findViewById(R.id.altezza_InviaDoni);
        Larghezza = findViewById(R.id.larghezza_InviaDoni);
        Data = findViewById(R.id.data_InviaDoni);
        Biglietto = findViewById(R.id.biglietto_InviaDoni);
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

    private void allert(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(InviaDoniActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(InviaDoniActivity.this);
        }
        builder.setTitle("Attenzione!")
                .setMessage("Sei sicuro di voler inviare il dono?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(InviaDoniActivity.this, "Grazie, uno dei nostri corrieri verra' a ritirare il pacco nella data da te indicata", Toast.LENGTH_LONG).show();
                        intent=new Intent(InviaDoniActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent(InviaDoniActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
