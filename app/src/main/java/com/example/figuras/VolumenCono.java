package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenCono extends AppCompatActivity {

    EditText radioCono, alturaCono;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cono);
        radioCono = findViewById(R.id.editTextRadioCono);
        alturaCono= findViewById(R.id.editTextAlturaCono);
    }


    public void calcularVolumenCono(View v) {
        if(validar()) {
            Double radio = Double.parseDouble(radioCono.getText().toString());
            Double altura = Double.parseDouble(alturaCono.getText().toString());
            Double resultado = (3.1416 * radio * radio * altura) / 3;
            Operacion ope = new Operacion(getString(R.string.volumen_de_cono), getString(R.string.radio) + " : " + radio + "\n" + getString(R.string.altura) + " : " + altura, "" + resultado);
            ope.guardar();
            intent = new Intent(VolumenCono.this, Resultado.class);
            intent.putExtra("titulo", getString(R.string.cono));
            intent.putExtra("tipoCalculo", getString(R.string.volumenes));
            intent.putExtra("medida", "m3");
            intent.putExtra("resultado", "" + resultado.toString());
            startActivity(intent);
        }
    }

    public void limpiar(View v) {
        radioCono.setText("");
        alturaCono.setText("");
        radioCono.requestFocus();
    }

    public boolean validar(){
        if (radioCono.getText().toString().isEmpty()) {
            radioCono.setError(getString(R.string.ingrese_radio));
            radioCono.requestFocus();
            return false;
        }

        if (alturaCono.getText().toString().isEmpty()) {
            alturaCono.setError(getString(R.string.ingrese_altura));
            alturaCono.requestFocus();
            return false;
        }
        return true;
    }

}