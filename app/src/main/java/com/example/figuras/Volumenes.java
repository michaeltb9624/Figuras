package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumenes extends AppCompatActivity {

    private ListView lista_opciones_voluemenes;
    private String opciones_volumenes[];
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);

        lista_opciones_voluemenes = findViewById(R.id.lstVolumenes);
        opciones_volumenes = getResources().getStringArray(R.array.volumenes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones_volumenes);
        lista_opciones_voluemenes.setAdapter(adapter);

        lista_opciones_voluemenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(Volumenes.this, VolumenEsfera.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Volumenes.this , VolumenCilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Volumenes.this , VolumenCono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Volumenes.this , VolumenCubo.class);
                        startActivity(intent);
                        break;



                }
            }
        });

    }
}