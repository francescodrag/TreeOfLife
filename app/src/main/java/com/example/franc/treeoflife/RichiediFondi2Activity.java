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

public class RichiediFondi2Activity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra, RichiediFondi;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;
    TextView Comunita, Importo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_richiedi_fondi2);

        setupView();
        getUtente();

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RichiediFondi2Activity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RichiediFondi2Activity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RichiediFondi2Activity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RichiediFondi2Activity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RichiediFondi2Activity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        RichiediFondi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Comunita.getText().toString().equals("") || Importo.getText().toString().equals(""))
                    Toast.makeText(RichiediFondi2Activity.this, "Compila tutti i campi, per favore.", Toast.LENGTH_SHORT).show();
                else
                    allert();
            }
        });

    }

    private void setupView() {
        HomePage = findViewById(R.id.home_RichiediFondi2);
        LavoraConNoi = findViewById(R.id.lavora_RichiediFondi2);
        AdottaOra = findViewById(R.id.adotta_RichiediFondi2);
        Area = findViewById(R.id.area_RichiediFondi2);
        Logo = findViewById(R.id.logo_RichiediFondi2);
        RichiediFondi = findViewById(R.id.richiediFondi_RichiediFondi2);
        Comunita = findViewById(R.id.comunita_RichiediFondi2);
        Importo = findViewById(R.id.importo_RichiediFondi2);
    }

    private void getUtente() {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null)
            utente = (Utente) extras.getSerializable("Utente");
    }

    private void inviaUtente(Utente utente) {
        Bundle extras = new Bundle();
        extras.putSerializable("Utente", utente);
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void allert(){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(RichiediFondi2Activity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(RichiediFondi2Activity.this);
        }
        builder.setTitle("Attenzione!")
                .setMessage("Richiedere fondi?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RichiediFondi2Activity.this, "Richiesta fondi effettuata correttamente!", Toast.LENGTH_LONG).show();
                        intent=new Intent(RichiediFondi2Activity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent(RichiediFondi2Activity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

