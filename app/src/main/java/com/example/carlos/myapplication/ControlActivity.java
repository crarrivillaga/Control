package com.example.carlos.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {

    EditText eTUser;
    EditText eTPassword;
    Button  buttonPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        eTUser = (EditText) findViewById(R.id.eTUser);
        eTPassword = (EditText) findViewById(R.id.eTPassword);
        buttonPanel = (Button) findViewById(R.id.buttonPanel);

        buttonPanel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                VerificarLogin(eTUser.getText().toString().toLowerCase(),eTPassword.getText().toString().toLowerCase());

            }
        });
    }

    public void VerificarLogin(String user, String password) {
        Toast.makeText(this, "El usuario es:"+user+"y la contraseña es:", Toast.LENGTH_SHORT).show();
    }

}
