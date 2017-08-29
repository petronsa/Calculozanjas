package com.app.petron.calculozanjas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;







public class MainActivity extends AppCompatActivity {
    private StartAppAd startAppAd = new StartAppAd(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "101423750", "210265439", true);
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
    @Override
    public void onBackPressed() {
        super.onBackPressed();


        //poner en marcha la publicidad al salir
        MainActivity.this.startAppAd.showAd();
        MainActivity.this.startAppAd.loadAd();

    }

    @Override
    public void onPause() {
        super.onPause();
        startAppAd.onPause();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {


            case R.id.fuera:
                //botón salir
                MainActivity.this.startAppAd.showAd();
                MainActivity.this.startAppAd.loadAd();

                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
