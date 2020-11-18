package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends AppCompatActivity {

    private ListView lista_opciones_areas;
    private String opciones_areas[];
    private ArrayAdapter<String> adapter;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);

        lista_opciones_areas = findViewById(R.id.lstOpciones);
        opciones_areas = getResources().getStringArray(R.array.opciones);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones_areas);
        lista_opciones_areas.setAdapter(adapter);

        lista_opciones_areas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(Areas.this, AreaCuadrado.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Areas.this , AreaRectangulo.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Areas.this , AreaTriangulo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Areas.this , AreaCirculo.class);
                        startActivity(intent);
                        break;



                }
            }
        });

    }
}