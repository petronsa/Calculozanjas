package com.app.petron.calculozanjas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button zanja_normal = (Button) findViewById(R.id.boton_zanja_normal);
        Button zanja_vegetal = (Button) findViewById(R.id.boton_zanja_vegetal);

        zanja_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Zanja_Normal.class);
                startActivity(i);
            }
        });

        zanja_vegetal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Zanja_Dos.class);
                startActivity(i);
            }
        });

    }
}
