package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InviaDoniActivity extends Activity {

    Button HomePage, LavoraConNoi, AdottaOra, InviaDoni;
    ImageView Area, Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invia_doni);

        setupView();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, LavoraConNoiActivity.class));
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, HomeActivity.class));
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, HomeActivity.class));
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, AreaActivity.class));
            }
        });

        InviaDoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        AdottaOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InviaDoniActivity.this, AdottaOraActivity.class));
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
    }
}
