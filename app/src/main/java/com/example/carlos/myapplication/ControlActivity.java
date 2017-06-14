package com.example.carlos.myapplication;

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

//conexion a firebase
import com.example.carlos.myapplication.view.OptionsActivity;
import com.example.carlos.myapplication.objects.FirebaseReferences;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class ControlActivity extends AppCompatActivity {

    EditText eTUser;
    EditText eTPassword;
    Button  buttonPanel;
    //private DatabaseReference DatabaseReference_myRef;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        eTUser = (EditText) findViewById(R.id.eTUser);
        eTPassword = (EditText) findViewById(R.id.eTPassword);
        buttonPanel = (Button) findViewById(R.id.buttonLogin);

        buttonPanel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //VerificarLogin(eTUser.getText().toString().toLowerCase(),eTPassword.getText().toString().toLowerCase());
                String userLog = eTUser.getText().toString();
                String passLog = eTPassword.getText().toString();
                LogIn(userLog,passLog);
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user =  firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.i("SESION", "sesion iniciada con email: " + user.getEmail());

                }else{
                    Log.i("SESION", "sesion cerrada");
                }
            }
        };

        //firebase database
        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference_myRef = database.getReference(FirebaseReferences.Control_Reference);*/

    }

    private void LogIn(String user, String password){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(user,password);
    }

    /*public void VerificarLogin(String user, String password) {
        Toast.makeText(this, "El usuario es:"+user+"y la contraseña es:", Toast.LENGTH_SHORT).show();
    }*/

    protected void onStar() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    protected void onStop() {
        super.onStop();
        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }


}
