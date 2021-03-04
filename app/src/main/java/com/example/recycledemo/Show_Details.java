package com.example.recycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Show_Details extends AppCompatActivity {
    TextView Name,Phone,Mail,Website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__details);

        Name = findViewById(R.id.detailsName);
        Phone =findViewById(R.id.detailsMob);
        Mail = findViewById(R.id.detailsMail);
        Website= findViewById(R.id.detailsWeb);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nName");
        String mob = intent.getStringExtra("nMob");
        String mail = intent.getStringExtra("nMail");
        String web = intent.getStringExtra("nWeb");
        Name.setText(name);
        Phone.setText(mob);
        Mail.setText(mail);
        Website.setText(web);
    }
}