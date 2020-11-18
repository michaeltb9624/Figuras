package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AreaCuadrado extends AppCompatActivity {

    Button btnCalcular;
    EditText ladoCuadrado;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cuadrado);

        btnCalcular = findViewById(R.id.btnCalcAreaCuadrado);
        ladoCuadrado = findViewById(R.id.editTextValorLado);
    }


    public void CalcularAreaCuadrado (View v){
        Double lado = Double.parseDouble(ladoCuadrado.getText().toString());
        Double resultado= lado*lado;
        intent = new Intent(AreaCuadrado.this, Resultado.class);
        intent.putExtra("titulo", "Cuadrado") ;
        intent.putExtra("tipoCalculo", "Area") ;
        intent.putExtra("medida", "m2") ;
        intent.putExtra("resultado", ""+resultado.toString());
        startActivity(intent);
    }
}