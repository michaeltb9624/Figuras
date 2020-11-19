package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AreaCirculo extends AppCompatActivity {

    EditText radioCirculo;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);

        radioCirculo = findViewById(R.id.editTextRadioCirculo);
    }


    public void calcularAreaCirculo (View v){
        if(validar()) {
            Double radio = Double.parseDouble(radioCirculo.getText().toString());
            Double resultado = 3.1416 * (radio * radio);
            Operacion ope = new Operacion(getString(R.string.area_del_circulo), getString(R.string.radio) + " : " + radio, "" + resultado);
            ope.guardar();
            intent = new Intent(AreaCirculo.this, Resultado.class);
            intent.putExtra("titulo", getString(R.string.circulo));
            intent.putExtra("tipoCalculo", getString(R.string.areas));
            intent.putExtra("medida", "m2");
            intent.putExtra("resultado", "" + resultado.toString());
            startActivity(intent);
        }
    }

    public void limpiar (View v){
        radioCirculo.setText("");
        radioCirculo.requestFocus();
    }

    public boolean validar(){
        if (radioCirculo.getText().toString().isEmpty()) {
            radioCirculo.setError(getString(R.string.ingrese_radio));
            radioCirculo.requestFocus();
            return false;
        }
        return true;
    }
}
