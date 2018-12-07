package com.example.franc.treeoflife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdottaOraActivity extends Activity {

    Button HomePage, LavoraConNoi, Adotta;
    ImageView Area, Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adotta_ora);

        setupView();

        LavoraConNoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdottaOraActivity.this, LavoraConNoiActivity.class));
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdottaOraActivity.this, HomeActivity.class));
            }
        });

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdottaOraActivity.this, HomeActivity.class));
            }
        });

        Area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdottaOraActivity.this, AreaActivity.class));
            }
        });

        Adotta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void setupView() {
        HomePage = findViewById(R.id.home_Adotta);
        LavoraConNoi = findViewById(R.id.lavora_Adotta);
        Adotta = findViewById(R.id.adottaOra_Adotta);
        Area = findViewById(R.id.area_Adotta);
        Logo = findViewById(R.id.logo_Adotta);
    }
}
