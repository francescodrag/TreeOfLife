package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends Activity {

    TextView test;
    Utente utente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        test = findViewById(R.id.test_Home);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            utente = (Utente) extras.getSerializable("Utente");
        }
        test.setText(utente.toString());

    }
}
