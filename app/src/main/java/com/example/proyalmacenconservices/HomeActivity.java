package com.example.proyalmacenconservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {


    private FirebaseAuth auth;
    private DatabaseReference dbProd;

//    static TextView pTvProd;

    TextView pTvQuantity1;
    TextView pTvQuantity2;
    TextView pTvQuantity3;
    TextView pTvQuantity4;
    TextView pTvQuantity5;
    TextView pTvQuantity6;
    TextView pTvQuantity7;
    TextView pTvQuantity8;
    TextView pTvQuantity9;
    TextView pTvQuantity10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();

//        pTvSection = (TextView) findViewById(R.id.tvValueSection1);
//        pTvQuantity = (TextView) findViewById(R.id.tvValueQuantity1);

        pTvQuantity1 = (TextView) findViewById(R.id.tvValueQuantity1);
        pTvQuantity2 = (TextView) findViewById(R.id.tvValueQuantity2);
        pTvQuantity3 = (TextView) findViewById(R.id.tvValueQuantity3);
        pTvQuantity4 = (TextView) findViewById(R.id.tvValueQuantity4);
        pTvQuantity5 = (TextView) findViewById(R.id.tvValueQuantity5);
        pTvQuantity6 = (TextView) findViewById(R.id.tvValueQuantity6);
        pTvQuantity7 = (TextView) findViewById(R.id.tvValueQuantity7);
        pTvQuantity8 = (TextView) findViewById(R.id.tvValueQuantity8);
        pTvQuantity9 = (TextView) findViewById(R.id.tvValueQuantity9);
        pTvQuantity10 = (TextView) findViewById(R.id.tvValueQuantity10);


        String optProduct[] = {"Azucar", "Harina de trigo", "Arroz", "Fideos", "Picota de mango", "Pala con mango", "Kit de cocina", "Kit de limpieza", "Kit de higiene", "Otros"};
        final int optCapacity[] = {14750, 12300, 12300, 8938, 506, 360, 2520, 2223, 2223, 10000};


        mostrarDatos(optProduct);

    }

    public void mostrarDatos(final String optProduct[]){
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[0]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity1.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[1]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity2.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[2]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity3.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[3]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity4.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[4]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity5.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[5]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity6.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[6]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity7.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[7]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity8.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[8]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity9.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        dbProd = FirebaseDatabase.getInstance().getReference("CantidadProductos").child(optProduct[9]);
        dbProd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pTvQuantity10.setText("" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
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
