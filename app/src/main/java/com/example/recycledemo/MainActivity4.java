package com.example.recycledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    EditText EdtName,EdtMob,EdtMail,EdtWeb;
    Button BtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        EdtName = findViewById(R.id.Editxml1);
        EdtMob = findViewById(R.id.Editxml2);
        EdtMail = findViewById(R.id.Editxml3);
        EdtWeb = findViewById(R.id.Editxml4);
        BtnSubmit = findViewById(R.id.SubmitBtn);

        BtnSubmit.setOnClickListener(new SubmitbtnClickListener());
    }

    class SubmitbtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity4.this,MainActivity3.class);
            String name=EdtName.getText().toString().trim();
            String mob=EdtMob.getText().toString().trim();
            String mail=EdtMail.getText().toString().trim();
            String web = EdtWeb.getText().toString().trim();

            intent.putExtra("Name",name);
            setResult(Activity.RESULT_OK,intent);
            intent.putExtra("Mob",mob);
            intent.putExtra("Mail",mail);
            intent.putExtra("Web",web);
            finish();

        }
    }










}