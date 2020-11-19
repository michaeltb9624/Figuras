package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenCubo extends AppCompatActivity {

    EditText ladoCubo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cubo);

        ladoCubo = findViewById(R.id.editTextLadoCubo);
    }


    public void calcularVolumenCubo (View v){
        Double lado = Double.parseDouble(ladoCubo.getText().toString());
        Double resultado= lado*lado*lado;
        Operacion ope = new Operacion(getString(R.string.volumen_de_cubo), getString(R.string.lado)+" : " + lado ,""+resultado);
        ope.guardar();
        intent = new Intent(VolumenCubo.this, Resultado.class);
        intent.putExtra("titulo", getString(R.string.cubo)) ;
        intent.putExtra("tipoCalculo", getString(R.string.areas)) ;
        intent.putExtra("medida", "m3") ;
        intent.putExtra("resultado", ""+resultado.toString());
        startActivity(intent);
    }

    public void limpiar (View v){
        ladoCubo.setText("");
        ladoCubo.requestFocus();
    }
}