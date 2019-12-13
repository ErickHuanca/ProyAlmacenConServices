package com.example.proyalmacenconservices;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class DetalleActivity extends AppCompatActivity {

    FirebaseAuth auth;

    private TextView pDetalleGral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        auth = FirebaseAuth.getInstance();

        pDetalleGral = (TextView)findViewById(R.id.tvDetalleGral);
        mostrarDetalleGral();

    }

    public void mostrarDetalleGral (){

        String idUser = auth.getCurrentUser().getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        //este es una peticion query de productos con el id de usuario
        Query query = reference.child("Products").orderByChild("iduser").equalTo(idUser);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mensaje = "Emisor    Producto    Cantidad    Ingreso    HoraIngreso \n";
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        mensaje = mensaje +
                                issue.child("nombreEmisor").getValue().toString()+"     "+
                                issue.child("product").getValue().toString()+"     "+
                                issue.child("quantity").getValue().toString()+"     "+
                                issue.child("date").getValue().toString()+"     "+
                                issue.child("time").getValue().toString()+"\n";

                    }
                    pDetalleGral.setText(mensaje);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
