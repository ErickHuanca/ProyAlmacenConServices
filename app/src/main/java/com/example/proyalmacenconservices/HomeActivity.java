package com.example.proyalmacenconservices;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
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

    public void btnAzucar(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Azucar")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        //        String idUser = auth.getCurrentUser().getUid();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
//
//        //este es una peticion query de productos con el id de usuario
//        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
//        query.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String mensaje = "";
//                if (dataSnapshot.exists()) {
//                    // dataSnapshot is the "issue" node with all children with id 0
//                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
//                        // do something with the individual "issues"
//                        mensaje = mensaje + issue.child("product").getValue().toString()+" "+issue.child("quantity").getValue().toString()+"\n";
//
//                    }
//                    Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG).show();
//                }
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
    }

    public void btnHarina(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Harina de trigo")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnArroz(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Arroz")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnFideos(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Fideos")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnPicota(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Picota de mango")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnPala(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Pala con mango")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnCocina(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Kit de cocina")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnLimpieza(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Kit de limpieza")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnHigiene(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Kit de higiene")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnOtros(View vista){
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        //este es una peticion query de productos con el id de usuario y producto especificco en la pantalla home boton DET
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Producto  Cantidad    FechaIngreso\n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot dbUser : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        String x = dbUser.child("product").getValue().toString();
                        if (x.equals("Otros")){
                            mensaje = mensaje +
                                    dbUser.child("product").getValue().toString()+"         "+
                                    dbUser.child("quantity").getValue().toString()+"        "+
                                    dbUser.child("date").getValue().toString()+"\n";
                        }
                    }
                    Toast toast = Toast.makeText(HomeActivity.this,mensaje, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void btnHistoriaGral(View v){
        startActivity(new Intent(HomeActivity.this, DetalleActivity.class));
    }
}
