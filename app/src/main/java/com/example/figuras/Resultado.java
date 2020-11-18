package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    TextView tituloResultado, tipoCalculo;
    Intent intent;
    Button botonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        tituloResultado = findViewById(R.id.txtTituloResultado);
        tipoCalculo = findViewById(R.id.txtTipoCalculo);
        botonOk = findViewById(R.id.btnOk);
        tituloResultado.setText(getIntent().getStringExtra("titulo"));
        tipoCalculo.setText(getIntent().getStringExtra("tipoCalculo") +" : "+ getIntent().getStringExtra("resultado") +" "+ getIntent().getStringExtra("medida"));

        botonOk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                intent = new Intent(Resultado.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}