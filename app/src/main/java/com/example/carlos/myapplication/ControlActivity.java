package com.example.carlos.myapplication;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.carlos.myapplication.view.OptionsActivity;

import java.util.HashMap;
import java.util.Map;

//conexion a firebase
/*import com.example.carlos.myapplication.view.OptionsActivity;
import com.example.carlos.myapplication.objects.FirebaseReferences;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;*/

public class ControlActivity extends AppCompatActivity {

    EditText eTUser;
    EditText eTPassword;
    Button  buttonPanel;

    JsonObjectRequest array;
    RequestQueue mRequestQueue;
    private final String url = "http://192.168.1.103:8080/rest_api/public/api/v1/iniciarSesion";
    private final String TAG = "Testing";

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
                mRequestQueue = VolleySingleton.getInstance().getmRequestQueue();
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String token = response;
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<String, String>();
                        map.put("email", eTUser.getText().toString());
                        map.put("password", eTPassword.getText().toString());
                        return map;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("Content-Type","application/x-www-form-urlencoded");
                        return params;
                    }
                };
                mRequestQueue.add(request);
               // VerificarLogin(eTUser.getText().toString().toLowerCase(),eTPassword.getText().toString().toLowerCase());
            }
        });
        Intent intent = new Intent(this, OptionsActivity.class);
        //el primer parametro es "en donde estoy", el segundo es "a donde voy"
        startActivity(intent);
    }

    /*
    public void VerificarLogin(String user, String password) {
        Toast.makeText(this, "El usuario es:"+user+"y la contraseña es:", Toast.LENGTH_SHORT).show();

    }
    */
}