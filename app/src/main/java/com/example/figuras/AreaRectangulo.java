package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreaRectangulo extends AppCompatActivity {

    EditText baseRectangulo, alturaRectangulo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_rectangulo);
        baseRectangulo = findViewById(R.id.editTextValorBaseRectangulo);
        alturaRectangulo = findViewById(R.id.editTextValorAlturaRectangulo);
    }

    public void calcularAreaRectangulo (View v){
    if(validar()) {
        Double base = Double.parseDouble(baseRectangulo.getText().toString());
        Double altura = Double.parseDouble(alturaRectangulo.getText().toString());
        Double resultado = base * altura;
        Operacion ope = new Operacion(getString(R.string.area_del_rectangulo), getString(R.string.base) + " : " + base + "\n" + getString(R.string.altura) + " : " + altura, "" + resultado);
        ope.guardar();
        intent = new Intent(AreaRectangulo.this, Resultado.class);
        intent.putExtra("titulo", getString(R.string.rectangulo));
        intent.putExtra("tipoCalculo", getString(R.string.areas));
        intent.putExtra("medida", "m2");
        intent.putExtra("resultado", "" + resultado.toString());
        startActivity(intent);
    }
    }

    public void limpiar (View v){
        baseRectangulo.setText("");
        alturaRectangulo.setText("");
        baseRectangulo.requestFocus();
    }

    public boolean validar(){
        if (baseRectangulo.getText().toString().isEmpty()) {
            baseRectangulo.setError(getString(R.string.ingrese_base));
            baseRectangulo.requestFocus();
            return false;
        }

        if (alturaRectangulo.getText().toString().isEmpty()) {
            alturaRectangulo.setError(getString(R.string.ingrese_altura));
            alturaRectangulo.requestFocus();
            return false;
        }
        return true;
    }


}