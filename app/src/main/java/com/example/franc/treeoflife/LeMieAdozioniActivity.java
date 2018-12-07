package com.example.franc.treeoflife;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class LeMieAdozioniActivity extends Activity {
    Button inviaDoni,organizzaIncontro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_adozioni);
        setupViews();
    }

    private void setupViews() {
        inviaDoni=findViewById(R.id.InviaDoni_Adozione);
        organizzaIncontro=findViewById(R.id.OrganizzaIncontro_Adozioni);

    }
}
