package com.example.figuras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;

public class OperacionesRealizadas extends AppCompatActivity {


    private TableLayout tabla;
    private ArrayList<Operacion> operaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_realizadas);


    }
}