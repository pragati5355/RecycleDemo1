package com.example.recycledemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.ViewHolder> {

    Context nContext;
    List<Modelclass> nmodelList;


    public Adapterclass(Context nContext, List<Modelclass> nmodelList) {
        this.nContext = nContext;
        this.nmodelList = nmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View CustomList = LayoutInflater.from(parent.getContext()).inflate(R.layout.customized_list,parent,false);

        return new ViewHolder(CustomList);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterclass.ViewHolder holder, int position) {
           Modelclass classm = nmodelList.get(position);
           holder.nametxt.setText(classm.getTxtName());
           holder.mobtxt.setText(classm.getTxtMob());
           holder.mailtxt.setText(classm.getTxtMail());
           holder.webtxt.setText(classm.getTxtWeb());
    }

    @Override
    public int getItemCount() {
        return nmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nametxt,mobtxt,mailtxt,webtxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nametxt = itemView.findViewById(R.id.CustomName);
            mobtxt = itemView.findViewById(R.id.CustomMob);
            mailtxt = itemView.findViewById(R.id.CustomMail);
            webtxt = itemView.findViewById(R.id.CustomWebsite);


            nametxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(nContext,Show_Details.class);
                    intent.putExtra("nName",nametxt.getText().toString().trim());
                    intent.putExtra("nMob",mobtxt.getText().toString().trim());
                    intent.putExtra("nMail",mailtxt.getText().toString().trim());
                    intent.putExtra("nWeb",webtxt.getText().toString().trim());

                    nContext.startActivity(intent);
                }
            });

            mobtxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentCall= new Intent(Intent.ACTION_DIAL);
                    Intent intentC=new Intent(Intent.ACTION_CALL_BUTTON);
                    Intent intentCa=new Intent(Intent.ACTION_CALL);
                    //intentCall.setData(Uri.parse("Tel:"+mobtxt.getText().toString().trim()));
                    nContext.startActivity(intentCall);
                    nContext.startActivity(intentC);
                    nContext.startActivity(intentCa);
                }
            });

            mailtxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentE = new Intent(Intent.ACTION_SEND
                            ,Uri.parse("mailto:"+ mailtxt.getText().toString().trim()));
                    intentE.putExtra(Intent.EXTRA_SUBJECT,"Message");
                    intentE.putExtra(Intent.EXTRA_TEXT,"Hello");
                    intentE.setType("message/rfc822");
                    nContext.startActivity(Intent.createChooser(intentE,"Choose an Valid Email"));
                }
            });

            webtxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentW = new Intent(Intent.ACTION_VIEW);
                    intentW.setData(Uri.parse("https://"+webtxt.getText().toString().trim()));
                    nContext.startActivity(intentW);
                }
            });

        }
    }
}
