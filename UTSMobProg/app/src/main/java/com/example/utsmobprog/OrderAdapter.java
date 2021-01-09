package com.example.utsmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {

    Context context;
    List<DrinkType> listOrder;

    public OrderAdapter(Context context, List<DrinkType> listOrder) {
        this.context = context;
        this.listOrder = listOrder;
    }

    @Override
    public int getCount() {
        return listOrder.size();
    }

    @Override
    public Object getItem(int position) {
        return listOrder.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.drink_ordered,null,false);

        final TextView nameDrink = convertView.findViewById(R.id.nameDrink);
        final TextView drink_price = convertView.findViewById(R.id.drink_price);
        final TextView drinkQty = convertView.findViewById(R.id.drinkQty);
        final Button removeBtn = convertView.findViewById(R.id.removeBtn);



        nameDrink.setText(listOrder.get(position).getNameDrink());
        drink_price.setText("Rp. " + listOrder.get(position).getPriceDrink());
        drinkQty.setText(" x " + listOrder.get(position).getQuantityDrink());

        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0 ;i<listOrder.size();i++){
                    listOrder.remove(i);
                    notifyDataSetChanged();
                }
            }
        });



        return convertView;
    }
}
