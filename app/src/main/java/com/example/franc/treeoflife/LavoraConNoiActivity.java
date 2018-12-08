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

public class LavoraConNoiActivity extends Activity {

    Button HomePage, DiventaVolontario, AdottaOra;
    TextView Nome, Cognome, Eta, Motivo;
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
                if(Nome.getText().toString().equals("")||Cognome.getText().toString().equals("")||Eta.getText().toString().equals("")||Motivo.getText().toString().equals(""))
                    Toast.makeText(LavoraConNoiActivity.this, "Compila tutti i campi, per favore.", Toast.LENGTH_SHORT).show();
                else
                    allert();
            }
        });
    }

    private void setupView() {
        HomePage = findViewById(R.id.home_LavoraConNoi);
        DiventaVolontario = findViewById(R.id.diventaVolontario_LavoraConNoi);
        AdottaOra = findViewById(R.id.adotta_LavoraConNoi);
        Area = findViewById(R.id.area_LavoraConNoi);
        Logo = findViewById(R.id.logo_LavoraConNoi);
        Nome = findViewById(R.id.nome_LavoraConNoi);
        Cognome = findViewById(R.id.cognome_LavoraConNoi);
        Eta = findViewById(R.id.eta_LavoraConNoi);
        Motivo = findViewById(R.id.motivo_LavoraConNoi);
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
            builder = new AlertDialog.Builder(LavoraConNoiActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(LavoraConNoiActivity.this);
        }
        builder.setTitle("Attenzione!")
                .setMessage("Sei sicuro di voler inviare la tua canditatura?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LavoraConNoiActivity.this, "Sarai contattato a breve. Keep In touch", Toast.LENGTH_LONG).show();
                        intent=new Intent(LavoraConNoiActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        intent=new Intent(LavoraConNoiActivity.this, HomeActivity.class);
                        inviaUtente(utente);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
