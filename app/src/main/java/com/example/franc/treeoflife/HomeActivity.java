package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {

    Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getUtente();

        Toast.makeText(HomeActivity.this, "Benvenuto, "+utente.getNome()+" "+utente.getCognome()+".", Toast.LENGTH_LONG).show();

        }

        private void getUtente(){
            Intent intent = getIntent();
            Bundle extras = intent.getExtras();
            if(extras!=null)
                utente = (Utente) extras.getSerializable("Utente");
        }
    }

