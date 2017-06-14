package com.example.carlos.myapplication.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.carlos.myapplication.R;
import com.example.carlos.myapplication.actions.CrearActivity;
import com.example.carlos.myapplication.actions.ConsultaActivity;
import com.example.carlos.myapplication.actions.EliminarActivity;
import com.example.carlos.myapplication.actions.ModificarActivity;

public class OptionsActivity extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void goCrear (View view){
        Intent intent = new Intent(this, CrearActivity.class);
        //el primer parametro es "en donde estoy", el segundo es "a donde voy"
        startActivity(intent);
    }

    public void goConsultar (View view){
        Intent intent = new Intent(this, ConsultaActivity.class);
        //el primer parametro es "en donde estoy", el segundo es "a donde voy"
        startActivity(intent);
    }

    public void goModificar (View view){
        Intent intent = new Intent(this, ModificarActivity.class);
        //el primer parametro es "en donde estoy", el segundo es "a donde voy"
        startActivity(intent);
    }

    public void goEliminar (View view){
        Intent intent = new Intent(this, EliminarActivity.class);
        //el primer parametro es "en donde estoy", el segundo es "a donde voy"
        startActivity(intent);
    }


}
