package com.example.utsmobprog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class drinkCustomLv extends RecyclerView.Adapter<drinkCustomLv.MyViewHolder> {

    private String[] drinkName;
    private int[] drinkPrice;
    private int[] drinkImage;
    private Activity context;

    public drinkCustomLv(Activity context, String[] drinkName,int[] drinkPrice,int[] drinkImage) {
        this.context = context;
        this.drinkName = drinkName;
        this.drinkImage = drinkImage;
        this.drinkPrice = drinkPrice;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_drink,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.nameTxt.setText(drinkName[position]);
        holder.priceTxt.setText("" + drinkPrice[position]);
        holder.imgView.setImageResource(drinkImage[position]);



        holder.rowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,Order.class);
                i.putExtra("drinksName",drinkName[position]);
                i.putExtra("drinksPrice","" + drinkPrice[position]);
                i.putExtra("drinksImage",drinkImage[position]);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinkImage.length;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameTxt;
        TextView priceTxt;
        ImageView imgView;
        ConstraintLayout rowLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = (TextView) itemView.findViewById(R.id.drinkName);
            priceTxt = (TextView) itemView.findViewById(R.id.drinkPrice);
            imgView = (ImageView) itemView.findViewById(R.id.drinkImg);
            rowLayout = itemView.findViewById(R.id.rowLayout);
        }
    }
}
