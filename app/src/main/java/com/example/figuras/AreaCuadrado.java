package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AreaCuadrado extends AppCompatActivity {

    EditText ladoCuadrado;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);

        ladoCuadrado = findViewById(R.id.editTextValorLado);
    }


    public void calcularAreaCuadrado (View v){

        if(validar()) {
            Double lado = Double.parseDouble(ladoCuadrado.getText().toString());
            Double resultado = lado * lado;
            Operacion ope = new Operacion(getString(R.string.area_del_cuadrado), getString(R.string.lado) + " : " + lado, "" + resultado);
            ope.guardar();
            intent = new Intent(AreaCuadrado.this, Resultado.class);
            intent.putExtra("titulo", getString(R.string.cuadrado));
            intent.putExtra("tipoCalculo", getString(R.string.areas));
            intent.putExtra("medida", "m2");
            intent.putExtra("resultado", "" + resultado.toString());
            startActivity(intent);
        }
    }

    public void limpiar (View v){
        ladoCuadrado.setText("");
        ladoCuadrado.requestFocus();
    }

    public boolean validar(){
        if (ladoCuadrado.getText().toString().isEmpty()) {
            ladoCuadrado.setError(getString(R.string.ingrese_lado));
            ladoCuadrado.requestFocus();
            return false;
        }
        return true;
    }
}