package com.app.petron.calculozanjas;

import android.icu.text.NumberFormat;
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

public class Zanja_Dos extends AppCompatActivity {
    Button calcular;
    TextView resultadoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zanja__dos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //mostrar icono flecha atras en el toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        calcular = (Button)findViewById(R.id.button_calcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularDosAlturas();
            }
        });


    }

    private void calcularDosAlturas() {
        double A = 0, B = 0, H = 0,H2=0, L = 0,C,DfH,DfA;
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

        EditText valorH2 = (EditText)findViewById(R.id.editTextH2);
        valorH2.getText().toString();
        if(valorH2.getText().toString().length() == 0){
            valorH2.setError(getText(R.string.error));
        }else{
            H2 = Double.parseDouble(valorH2.getText().toString());
        }

        EditText valorL = (EditText) findViewById(R.id.editTextL);
        valorL.getText().toString();
        if(valorL.getText().toString().length()==0){
            valorL.setError(getText(R.string.error));
        }else {
            L = Double.parseDouble(valorL.getText().toString());
        }

        //Vamos a calcular C
        DfH = H-H2;
        DfA = A-B;
        C = ((DfA*DfH)/H)+B;
        //Preparamos el redondeo con 2 digitos
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        //Mostramos C
        resultadoC = (TextView)findViewById(R.id.textViewResulC);
        resultadoC.setText(nf.format(C));

        //Calculo Area superior
        double Hsuperior = H-H2;
        double AreaSuperior = (Hsuperior*((A+C)/2));
        //Calculo volumen superior
        double VolumenSuperior = AreaSuperior*L;
        //Mostramos el volumen superior
        TextView VS = (TextView)findViewById(R.id.textViewrvs);

        VS.setText(nf.format(VolumenSuperior));

        //Calucular area inferior
        double AreaInferior =(H2*((C+B)/2));
        //Calculo volumen inferior
        double VolumenInferior = AreaInferior*L;
        //Mostramos el volumen inferior
        TextView VI = (TextView)findViewById(R.id.textViewrvi);
        VI.setText(nf.format(VolumenInferior));


       /* double Arera = (H*((A+B)/2));
        double Volumen = Arera*L;

        TextView Resultado = (TextView) findViewById(R.id.textViewResultado);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        Resultado.setText(nf.format(Volumen));*/

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
