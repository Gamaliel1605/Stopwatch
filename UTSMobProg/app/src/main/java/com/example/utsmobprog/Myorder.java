package com.example.utsmobprog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Myorder extends AppCompatActivity {

    Button paynow;
    ListView listViewOrder;
    List<DrinkType> listOrder;
    TextView total;
    int totalPayment=0;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);

        listOrder = Apps.getDrinkTypeList();
        total = (TextView) findViewById(R.id.total);


        final OrderAdapter adapter = new OrderAdapter(this,listOrder);
        total = findViewById(R.id.total);
        listViewOrder = findViewById(R.id.listViewOrder);
        listViewOrder.setAdapter(adapter);

        if(listOrder != null){
            int i;
            for(i = 0; i< listOrder.size() ; i++){
                totalPayment = totalPayment + (listOrder.get(i).getQuantityDrink() * listOrder.get(i).getPriceDrink());
            }
        }
        String totalTxt = Integer.toString(totalPayment);
        total.setText("Total : Rp. " + totalTxt);
        adapter.notifyDataSetChanged();



        paynow = (Button) findViewById(R.id.payBtn);
        paynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuccessDialog(v);
            }
        });

    }

    public void showSuccessDialog(View v){
        AlertDialog.Builder successAlert = new AlertDialog.Builder(this);
        successAlert.setTitle("Success");
        successAlert.setMessage("Payment Success");
        successAlert.setPositiveButton("Back to menu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Myorder.this,MainActivity.class);

                startActivity(i);
            }
        });

        successAlert.create().show();
    }

}
