package com.example.recycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Recycle_View3 extends AppCompatActivity {
    TextView txtname,txtmob,txtemail,txtadd,txtdob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle__view3);

        txtname = findViewById(R.id.TxtNameEdt);
        txtmob = findViewById(R.id.Txtmobedt);
        txtemail= findViewById(R.id.TxtEmailedt);
        txtadd = findViewById(R.id.TxtAddedt);
        txtdob = findViewById(R.id.TxtDobedt);

        Intent intent = getIntent();
        String name1= intent.getStringExtra("rName");
        String mob1= intent.getStringExtra("rMob");
        String Email1 = intent.getStringExtra("rEmail");
        String Address= intent.getStringExtra("rAdd");
        String Dob = intent.getStringExtra("rDob");

        txtname.setText(name1);
        txtmob.setText(mob1);
        txtemail.setText(Email1);
        txtadd.setText(Address);
        txtdob.setText(Dob);


    }
}