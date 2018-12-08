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

public class OrganizzaIncontroActivity extends Activity {
    Button HomePage, LavoraConNoi, AdottaOra, OrganizzaIncontro;
    TextView Periodo, Luogo;
    ImageView Area, Logo;
    Utente utente;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizza_incontro);

        setupView();
        getUtente();

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(OrganizzaIncontroActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(OrganizzaIncontroActivity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(OrganizzaIncontroActivity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(OrganizzaIncontroActivity.this, AdottaOraActivity.class);
                inviaUtente(utente);
            }
        });
        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(OrganizzaIncontroActivity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        OrganizzaIncontro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Periodo.getText().toString().equals("")||Luogo.getText().toString().equals(""))
                    Toast.makeText(OrganizzaIncontroActivity.this, "Compila tutti i campi, per favore.", Toast.LENGTH_SHORT).show();
                else
                    allert();
            }
        });
    }

    private void setupView() {
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Area = findViewById(R.id.area_Home);
        Logo = findViewById(R.id.logo_Home);
        Periodo = findViewById(R.id.periodo_OrganizzaIncontro);
        Luogo = findViewById(R.id.luogo_OrganizzaIncontro);
        OrganizzaIncontro = findViewById(R.id.organizzaIncontro_OrganizzaIncontro);
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
            builder = new AlertDialog.Builder(OrganizzaIncontroActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(OrganizzaIncontroActivity.this);
        }
        builder.setTitle("Attenzione!")
                .setMessage("Sei sicuro di voler organizzare l'incontro?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(OrganizzaIncontroActivity.this, "Ti abbiamo inviato un email con i dettagli", Toast.LENGTH_LONG).show();
                        intent=new Intent(OrganizzaIncontroActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent(OrganizzaIncontroActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
