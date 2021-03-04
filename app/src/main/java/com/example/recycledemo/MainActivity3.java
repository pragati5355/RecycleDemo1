package com.example.recycledemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    Button btn;
    RecyclerView recycleView;
    List<Modelclass> ModelList;
    Modelclass modelclass;
    Adapterclass adapterclass;
    static final int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn=findViewById(R.id.BAckbtn1);
        recycleView = findViewById(R.id.RecycleList);

        ModelList= new ArrayList<>();
        adapterclass = new Adapterclass(this,ModelList);
        recycleView.setAdapter(adapterclass);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(MainActivity3.this));

        btn.setOnClickListener(new BackbtnClickListener());

    }

    class BackbtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent1= new Intent(MainActivity3.this,MainActivity4.class);
            startActivityForResult(intent1,REQUEST_CODE);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (REQUEST_CODE==requestCode) {
            if (Activity.RESULT_OK==resultCode) {

                String name = data.getStringExtra("Name");
                String mob = data.getStringExtra("Mob");
                String mail = data.getStringExtra("Mail");
                String web = data.getStringExtra("Web");

                modelclass = new Modelclass();
                modelclass.setTxtName(name);
                modelclass.setTxtMob(mob);
                modelclass.setTxtMail(mail);
                modelclass.setTxtWeb(web);

                ModelList.add(modelclass);
                adapterclass.notifyDataSetChanged();
            }

        }
    }
}