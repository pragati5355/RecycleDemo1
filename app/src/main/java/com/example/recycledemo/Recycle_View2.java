package com.example.recycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Recycle_View2 extends AppCompatActivity {
    EditText Name,Mobile,Email,Address,Dob;
    Button BtnADD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle__view2);

        Name = findViewById(R.id.editTextName);
        Mobile = findViewById(R.id.editTextMob);
        Email = findViewById(R.id.editTextEmail);
        Address = findViewById(R.id.editTextAddress);
        Dob = findViewById(R.id.editTextDOB);
        BtnADD = findViewById(R.id.ADDBTN);

        BtnADD.setOnClickListener(new BtnADDinfo());
    }

    class BtnADDinfo implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            Intent intent1 = new Intent(Recycle_View2.this,Recycle_View1.class);
            String name = Name.getText().toString().trim();
            String mobile=Mobile.getText().toString().trim();
            String email= Email.getText().toString().trim();
            String add = Address.getText().toString().trim();
            String dob =Dob.getText().toString().trim();

            intent1.putExtra("NAME",name);
            intent1.putExtra("MOBILE",mobile);
            intent1.putExtra("EMAIL",email);
            intent1.putExtra("ADDRESS",add);
            intent1.putExtra("DOB",dob);
            setResult(Activity.RESULT_OK,intent1);
            finish();
        }
    }
}