package com.example.proyalmacenconservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void saveProduct (View vista){
        startActivity(new Intent(HomeActivity.this, ProductReceiptActivity.class));
//        finish();
    }

    public void sendProduct (View vista){
        startActivity(new Intent(HomeActivity.this, ProductDeliveryActivity.class));
//        finish();
    }
}
