package com.example.carlos.myapplication.actions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.carlos.myapplication.R;

public class CrearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        showToolbar(getResources().getString(R.string.crear_bar), true);
    }

    public void showToolbar(String title, boolean upButton){
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
