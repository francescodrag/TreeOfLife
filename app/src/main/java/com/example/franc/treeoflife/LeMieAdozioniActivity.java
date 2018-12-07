package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LeMieAdozioniActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra;
    ImageView Area, Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_le_mie_adozioni);

        setupView();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeMieAdozioniActivity.this, LavoraConNoiActivity.class));
            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeMieAdozioniActivity.this, AdottaOraActivity.class));
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeMieAdozioniActivity.this, HomeActivity.class));
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LeMieAdozioniActivity.this, AreaActivity.class));
            }
        });

    }

    private void setupView() {
        HomePage = findViewById(R.id.home_Home);
        LavoraConNoi = findViewById(R.id.lavora_Home);
        AdottaOra = findViewById(R.id.adotta_Home);
        Area = findViewById(R.id.area_Home);
        Logo = findViewById(R.id.logo_Home);
    }
}
