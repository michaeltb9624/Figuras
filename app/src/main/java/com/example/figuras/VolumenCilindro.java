package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class VolumenCilindro extends AppCompatActivity {

    EditText radioCilindro, alturaCilindro;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_cilindro);
        radioCilindro = findViewById(R.id.editTextRadioCilindro);
        alturaCilindro= findViewById(R.id.editTextAlturaCilindro);
    }


    public void calcularVolumenCilindro(View v) {
        if (validar()){
            Double radio = Double.parseDouble(radioCilindro.getText().toString());
        Double altura = Double.parseDouble(alturaCilindro.getText().toString());
        Double resultado = 3.1416 * radio * radio * altura;
        Operacion ope = new Operacion(getString(R.string.volumen_de_cilindro), getString(R.string.radio) + " : " + radio + "\n" + getString(R.string.altura) + " : " + altura, "" + resultado);
        ope.guardar();
        intent = new Intent(VolumenCilindro.this, Resultado.class);
        intent.putExtra("titulo", getString(R.string.cilindro));
        intent.putExtra("tipoCalculo", getString(R.string.volumenes));
        intent.putExtra("medida", "m3");
        intent.putExtra("resultado", "" + resultado.toString());
        startActivity(intent);
    }
    }

    public void limpiar(View v) {
        radioCilindro.setText("");
        alturaCilindro.setText("");
        radioCilindro.requestFocus();
    }



    public boolean validar(){
        if (radioCilindro.getText().toString().isEmpty()) {
            radioCilindro.setError(getString(R.string.ingrese_radio));
            radioCilindro.requestFocus();
            return false;
        }

        if (alturaCilindro.getText().toString().isEmpty()) {
            alturaCilindro.setError(getString(R.string.ingrese_altura));
            alturaCilindro.requestFocus();
            return false;
        }
        return true;
    }

}