package com.example.proyalmacenconservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText pEtCorreo;
    private EditText pEtContrasenia;
    private Button pBtnOjoVisible;
    private Button pBtnIngresar;
    private TextView pBtnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        pEtCorreo = (EditText) findViewById(R.id.etCorreo);
        pEtContrasenia = (EditText) findViewById(R.id.etContrasenia);
        pBtnIngresar = (Button) findViewById(R.id.btnIngresar);
        pBtnRegistrar = (TextView) findViewById(R.id.btnRegistrar);

        ocultarMostrarPass();
        iniciarSecion();
        btnRegistrarse();
    }
    public void ocultarMostrarPass(){
        pBtnOjoVisible = (Button) findViewById(R.id.btnEyeSignIn);
        pBtnOjoVisible.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch ( event.getAction() ) {
                            case MotionEvent.ACTION_DOWN:
                                pEtContrasenia.setInputType(InputType.TYPE_CLASS_TEXT);
                                break;
                            case MotionEvent.ACTION_UP:
                                pEtContrasenia.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                break;
                        }
                        return true;
                    }
                }
        );
    }

    public void iniciarSecion(){
        pBtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dEmail = pEtCorreo.getText().toString();
                String dPass = pEtContrasenia.getText().toString();

                mAuth.signInWithEmailAndPassword(dEmail, dPass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
                            finish();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                            Toast toastProduct = Toast.makeText(MainActivity.this,"Autenticacion Fallida!!!.",Toast.LENGTH_LONG);
                            toastProduct.setGravity(Gravity.CENTER, 0,0 );
                            toastProduct.show();
//                            updateUI(null);
                        }
                    }
                });
            }
        });
    }

    private void btnRegistrarse() {
        pBtnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent pVista = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(pVista);
            }
        });
    }
}
