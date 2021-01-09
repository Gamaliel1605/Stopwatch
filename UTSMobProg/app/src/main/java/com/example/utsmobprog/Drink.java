package com.example.utsmobprog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Drink extends AppCompatActivity {

    RecyclerView drinkList;
    String[] drinkName = {"Apple Juice","Avocado Juice","Bubble Tea","Kratingdaeng","Mineral Water","Orange Juice"};
    int[] drinkPrice = {25000,35000,28000,15000,5000,23000};
    int[] drinkImage = {R.drawable.apple_juice,R.drawable.avocado_juice,R.drawable.bubble_tea,R.drawable.krating,R.drawable.mineral_water,
    R.drawable.orange_juice};
    Button buttonMyOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        drinkList = findViewById(R.id.drinkList);
        drinkCustomLv drinkAdapter = new drinkCustomLv(this,drinkName,drinkPrice,drinkImage);
        drinkList.setAdapter(drinkAdapter);
        drinkList.setLayoutManager(new LinearLayoutManager(this));


        buttonMyOrder = (Button) findViewById(R.id.buttonMyOrder);
        buttonMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Drink.this,Myorder.class);
                startActivity(i);
            }
        });

    }
}

