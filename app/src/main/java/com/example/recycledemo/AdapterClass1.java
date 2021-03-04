package com.example.recycledemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterClass1 extends RecyclerView.Adapter<AdapterClass1.ViewHolder> {

    Context nContext;
    List<Recycle_Modelclass> nModelClass;

    public AdapterClass1(Context nContext, List<Recycle_Modelclass> nModelClass) {
        this.nContext = nContext;
        this.nModelClass = nModelClass;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recycleCustom = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_customizedlist,parent,false);
        return new ViewHolder(recycleCustom);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass1.ViewHolder holder, int position) {

        Recycle_Modelclass modelclass = nModelClass.get(position);
        holder.TxtName.setText(modelclass.getTextName());
        holder.TxtMob.setText(modelclass.getTextMob());
        holder.TxtEmail.setText(modelclass.getTextEmail());
        holder.TxtAdd.setText(modelclass.getTextAdd());
        holder.TxtDob.setText(modelclass.getTextDob());

    }

    @Override
    public int getItemCount() {
        return nModelClass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView TxtName,TxtMob,TxtEmail,TxtAdd,TxtDob;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TxtName = itemView.findViewById(R.id.Recycletxtchange);
            TxtMob = itemView.findViewById(R.id.txtcustommobile);
            TxtEmail=itemView.findViewById(R.id.txtcustomemail);
            TxtAdd = itemView.findViewById(R.id.txtcustomaddress);
            TxtDob = itemView.findViewById(R.id.txtcustomdob);


            TxtName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(nContext,Recycle_View3.class);
                    intent.putExtra("rName",TxtName.getText().toString().trim());
                    intent.putExtra("rMob",TxtMob.getText().toString().trim());
                    intent.putExtra("rEmail",TxtEmail.getText().toString().trim());
                    intent.putExtra("rAdd",TxtAdd.getText().toString().trim());
                    intent.putExtra("rDob",TxtDob.getText().toString().trim());

                    nContext.startActivity(intent);

                }
            });





        }
    }



}
