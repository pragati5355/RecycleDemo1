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

public class Recycle_View1 extends AppCompatActivity {
    Button Adduserbtn;
    RecyclerView Recycle_View;
    List<Recycle_Modelclass> ModelRecycleList;
    AdapterClass1 AdapterRecycle;
    Recycle_Modelclass modelclassrecycle;
    static final int Request_Code= 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle__view1);

        Adduserbtn = findViewById(R.id.ADDBtn);
        Recycle_View = findViewById(R.id.Recycle_List);

        ModelRecycleList = new ArrayList<>();
        AdapterRecycle = new AdapterClass1(this,ModelRecycleList);
        Recycle_View.setHasFixedSize(true);
        Recycle_View.setAdapter(AdapterRecycle);
        Recycle_View.setLayoutManager(new LinearLayoutManager(this));

        Adduserbtn.setOnClickListener(new ADDBtnUser());


    }

    class ADDBtnUser implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Recycle_View1.this,Recycle_View2.class);
            startActivityForResult(intent,Request_Code);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Request_Code==requestCode){
            if (Activity.RESULT_OK==resultCode){

                String name = data.getStringExtra("NAME");
                String Mob = data.getStringExtra("MOBILE");
                String Email= data.getStringExtra("EMAIL");
                String Add = data.getStringExtra("ADDRESS");
                String Dob= data.getStringExtra("DOB");

                modelclassrecycle = new Recycle_Modelclass();
                modelclassrecycle.setTextName(name);
                modelclassrecycle.setTextMob(Mob);
                modelclassrecycle.setTextEmail(Email);
                modelclassrecycle.setTextAdd(Add);
                modelclassrecycle.setTextDob(Dob);

                ModelRecycleList.add(modelclassrecycle);
                AdapterRecycle.notifyDataSetChanged();


            }
        }
    }
}