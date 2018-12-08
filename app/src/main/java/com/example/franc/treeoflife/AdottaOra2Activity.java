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

public class AdottaOra2Activity extends Activity {

    Utente utente;
    Intent intent;
    TextView Nome, Cognome, Importo, Iban, Telefono, Via, Civico, Cap;
    Button HomePage, LavoraConNoi, Adotta;
    ImageView Area, Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adotta_ora2);

        setupView();
        getUtente();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AdottaOra2Activity.this, LavoraConNoiActivity.class);
                inviaUtente(utente);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AdottaOra2Activity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AdottaOra2Activity.this, HomeActivity.class);
                inviaUtente(utente);
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(AdottaOra2Activity.this, AreaActivity.class);
                inviaUtente(utente);
            }
        });


        Adotta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Nome.getText().toString().equals("")||Cognome.getText().toString().equals("")||
                        Importo.getText().toString().equals("")||Iban.getText().toString().equals("")||
                        Telefono.getText().toString().equals("")||Via.getText().toString().equals("")||
                        Civico.getText().toString().equals("")||Cap.getText().toString().equals("")){
                    Toast.makeText(AdottaOra2Activity.this, "Compila tutti i campi, per favore.", Toast.LENGTH_SHORT).show();
                }else
                    allert();
            }
        });


    }

    private void setupView(){
        HomePage = findViewById(R.id.home_AdottaOra2);
        LavoraConNoi = findViewById(R.id.lavora_AdottaOra2);
        Adotta = findViewById(R.id.adottaOra_AdottaOra2);
        Area = findViewById(R.id.area_AdottaOra2);
        Logo = findViewById(R.id.logo_AdottaOra2);
        Nome = findViewById(R.id.nome_AdottaOra2);
        Cognome = findViewById(R.id.cognome_AdottaOra2);
        Importo = findViewById(R.id.importo_AdottaOra2);
        Iban = findViewById(R.id.iban_AdottaOra2);
        Telefono = findViewById(R.id.telefono_AdottaOra2);
        Via = findViewById(R.id.via_AdottaOra2);
        Civico = findViewById(R.id.civico_AdottaOra2);
        Cap = findViewById(R.id.cap_AdottaOra2);
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
            builder = new AlertDialog.Builder(AdottaOra2Activity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(AdottaOra2Activity.this);
        }
        builder.setTitle("Attenzione!")
                .setMessage("Adottare a distanza ora?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AdottaOra2Activity.this, "Grazie per aver adottato!", Toast.LENGTH_LONG).show();
                        intent=new Intent(AdottaOra2Activity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent(AdottaOra2Activity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
