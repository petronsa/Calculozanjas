package com.app.petron.calculozanjas;

import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Zanja_Normal extends AppCompatActivity {

    Button calcular;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zanja__normal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mostrar icono flecha atras en el toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        calcular = (Button) findViewById(R.id.button_calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculozanjanormal();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void calculozanjanormal() {
        double A = 0, B = 0, H = 0, L = 0;

        EditText valorA = (EditText) findViewById(R.id.editTextA);
        valorA.getText().toString();
        if (valorA.getText().toString().length() == 0) {
            valorA.setError(getText(R.string.error));
        } else {
            A = Double.parseDouble(valorA.getText().toString());
        }

        EditText valorB = (EditText) findViewById(R.id.editTextB);
        valorB.getText().toString();
        if (valorB.getText().toString().length() == 0) {
            valorB.setError(getText(R.string.error));
        }else{
            B = Double.parseDouble(valorB.getText().toString());
        }

        EditText valorH = (EditText) findViewById(R.id.editTextH);
        valorH.getText().toString();
        if (valorH.getText().toString().length()==0){
            valorH.setError(getText(R.string.error));
        }else {
            H = Double.parseDouble(valorH.getText().toString());
        }

        EditText valorL = (EditText) findViewById(R.id.editTextL);
        valorL.getText().toString();
        if(valorL.getText().toString().length()==0){
           valorL.setError(getText(R.string.error));
        }else {
            L = Double.parseDouble(valorL.getText().toString());
        }

        double Arera = (H*((A+B)/2));
        double Volumen = Arera*L;

        TextView Resultado = (TextView) findViewById(R.id.textViewResultado);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        Resultado.setText(nf.format(Volumen));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //función para que funcione la flecha atras del toolbar
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
