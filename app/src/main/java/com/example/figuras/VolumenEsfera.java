package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenEsfera extends AppCompatActivity {


    EditText radioEsfera;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_esfera);

        radioEsfera = findViewById(R.id.editTextRadioEsfera);
    }


    public void calcularVolumenEsfera (View v){
        Double radio = Double.parseDouble(radioEsfera.getText().toString());
        Double resultado= ((3.1416*(radio*radio*radio)*4))/3;
        Operacion ope = new Operacion(getString(R.string.volumen_de_esfera), getString(R.string.radio)+" : " + radio ,""+resultado);
        ope.guardar();
        intent = new Intent(VolumenEsfera.this, Resultado.class);
        intent.putExtra("titulo", getString(R.string.esfera)) ;
        intent.putExtra("tipoCalculo", getString(R.string.volumenes)) ;
        intent.putExtra("medida", "m3") ;
        intent.putExtra("resultado", ""+resultado.toString());
        startActivity(intent);
    }

    public void limpiar (View v){
        radioEsfera.setText("");
        radioEsfera.requestFocus();
    }
}