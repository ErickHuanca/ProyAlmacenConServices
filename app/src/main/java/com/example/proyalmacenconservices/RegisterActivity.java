package com.example.proyalmacenconservices;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private TextInputEditText pNombre;
    private TextInputEditText pEtCorreo;
    private TextInputEditText pEtContrasenia;
    private Button pBtnOjoVisible;
    private Button pBtnRegistrar;
    private String dName;
    private String dEmail;
    private String dPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        pNombre = findViewById(R.id.etName);
        pEtCorreo = findViewById(R.id.etEmail);
        pEtContrasenia = findViewById(R.id.etPassword);
        pBtnOjoVisible = findViewById(R.id.btnEye);
        pBtnRegistrar = (Button) findViewById(R.id.btnRegister);

        ocultarMostrarPass();
        registrarUsuario();
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

    public void registrarUsuario (){
        pBtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dName = pNombre.getText().toString();
                dEmail = pEtCorreo.getText().toString();
                dPass = pEtContrasenia.getText().toString();

                if (!dName.isEmpty() && !dEmail.isEmpty() && !dPass.isEmpty()){
                    if (dPass.length()>=6){
                        registerUser();
                    }else {
                        Toast.makeText(RegisterActivity.this,"La contraseñia debe ser mayor a 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }

    private void registerUser (){

        mAuth.createUserWithEmailAndPassword(dEmail,dPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Map<String,Object> map = new HashMap<>();
                    map.put("name",dName);
                    map.put("email",dEmail);
//                    map.put("pass",dPass);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                                finish();
                            }else {
//                              Toast.makeText(this,"No se puedo crear los datos correctamente",Toast.LENGTH_LONG).show();

                            }

                        }
                    });


                }else {
//                    Toast.makeText(this,"No se puedo registrar este usuario",Toast.LENGTH_LONG).show();

                }
            }
        });

    }

}
