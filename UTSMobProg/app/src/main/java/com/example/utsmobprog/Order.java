package com.example.utsmobprog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Order extends AppCompatActivity {
    TextView drink_detail_name;
    TextView drink_detail_price;
    ImageView drink_detail_image;
    Button orderMoreBtn;
    Button orderBtn;
    EditText qtyTxt;
    String orderName;
    int orderPrice,qtyFix;
    Apps apps = (Apps) this.getApplication();
    List<DrinkType> drinkTypes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        drinkTypes = apps.getDrinkTypeList();

        drink_detail_name = findViewById(R.id.drink_detail_name);
        drink_detail_price = findViewById(R.id.drink_detail_price);
        drink_detail_image = findViewById(R.id.drink_detail_image);



        if(getIntent().hasExtra("drinksName") && getIntent().hasExtra("drinksPrice") && getIntent().hasExtra("drinksImage")){
            drink_detail_name.setText(getIntent().getStringExtra("drinksName"));
            drink_detail_price.setText(getIntent().getStringExtra("drinksPrice"));
            drink_detail_image.setImageResource(getIntent().getIntExtra("drinksImage",0));
        }
        else{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }

        orderBtn = (Button) findViewById(R.id.orderBtn);
        orderMoreBtn = (Button) findViewById(R.id.orderMoreBtn);
        qtyTxt = (EditText)findViewById(R.id.qtyTxt);



        orderMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Order.this,Drink.class);
                startActivity(i);
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(qtyTxt.getText().toString().matches("")){
                    showAlertDialogError(v);
                }
                else{
                    showSuccessDialog(v);
                    int nextId = apps.getNextId();
                    orderName = drink_detail_name.getText().toString();
                    orderPrice = Integer.parseInt(drink_detail_price.getText().toString());
                    qtyFix = Integer.parseInt(qtyTxt.getText().toString());

                    DrinkType orderList = new DrinkType(orderName,qtyFix,orderPrice);

                    drinkTypes.add(orderList);
                    apps.setNextId(nextId++);

                }
            }
        });

    }




    public static final String orderedQty = "default";
    public static final String orderedName = "default1";
    public static final String orderedPrice = "default2";



    public void showSuccessDialog(View v){
        AlertDialog.Builder successAlert = new AlertDialog.Builder(this);
        successAlert.setTitle("Order Success");
        successAlert.setMessage("Complete Your Payment , Have a Nice Day");
        successAlert.setPositiveButton("Pay Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                int qtyNumber = Integer.parseInt(qtyTxt.getText().toString());
                Intent i = new Intent(Order.this,Myorder.class);
//                i.putExtra(orderedQty,qtyNumber);
//                i.putExtra(orderedName,orderName);
//                i.putExtra(orderedPrice,orderPrice);

                startActivity(i);
            }
        });
        successAlert.setNegativeButton("Order More", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Order.this,Drink.class);
                startActivity(i);
            }
        });
        successAlert.create().show();
    }

    public void  showAlertDialogError(View v){
        AlertDialog.Builder errorAlert = new AlertDialog.Builder(this);
        errorAlert.setTitle("Error");
        errorAlert.setMessage("Input your Quantity");
        errorAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        errorAlert.create().show();
    }

}
