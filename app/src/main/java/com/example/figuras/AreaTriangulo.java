package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreaTriangulo extends AppCompatActivity {

    EditText baseTriangulo, alturaTriangulo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangulo);
        baseTriangulo = findViewById(R.id.editTextValorBaseTriangulo);
        alturaTriangulo = findViewById(R.id.editTextValorAlturaTriangulo);
    }

    public void calcularAreaTriangulo (View v){
    if(validar()) {
        Double base = Double.parseDouble(baseTriangulo.getText().toString());
        Double altura = Double.parseDouble(alturaTriangulo.getText().toString());
        Double resultado = (base * altura) / 2;
        Operacion ope = new Operacion(getString(R.string.area_del_triangulo), getString(R.string.base) + " : " + base + "\n" + getString(R.string.altura) + " : " + altura, "" + resultado);
        ope.guardar();
        intent = new Intent(AreaTriangulo.this, Resultado.class);
        intent.putExtra("titulo", getString(R.string.triangulo));
        intent.putExtra("tipoCalculo", getString(R.string.areas));
        intent.putExtra("medida", "m2");
        intent.putExtra("resultado", "" + resultado.toString());
        startActivity(intent);
    }
    }

    public void limpiar (View v){
        baseTriangulo.setText("");
        alturaTriangulo.setText("");
        baseTriangulo.requestFocus();
    }

    public boolean validar(){
        if (baseTriangulo.getText().toString().isEmpty()) {
            baseTriangulo.setError(getString(R.string.ingrese_base));
            baseTriangulo.requestFocus();
            return false;
        }

        if (alturaTriangulo.getText().toString().isEmpty()) {
            alturaTriangulo.setError(getString(R.string.ingrese_altura));
            alturaTriangulo.requestFocus();
            return false;
        }
        return true;
    }
}