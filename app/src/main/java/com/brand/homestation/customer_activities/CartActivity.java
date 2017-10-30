package com.brand.homestation.customer_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.CartAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    Button orderNow;
    TextView title,total,price,text;
    RecyclerView recyclerCarts;
    FrameLayout order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        orderNow=(Button) findViewById(R.id.orderNow);
        title=(TextView) findViewById(R.id.title);
        total=(TextView) findViewById(R.id.total);
        price=(TextView) findViewById(R.id.price);
        order=(FrameLayout) findViewById(R.id.order);
        text=(TextView) findViewById(R.id.text);
        recyclerCarts=(RecyclerView) findViewById(R.id.recyclerCarts);
        recyclerCarts.setAdapter(new CartAdapter(this));
        recyclerCarts.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerCarts.setNestedScrollingEnabled(false);
        UtilitiesClass.setFont(orderNow,this,0);
        UtilitiesClass.setFont(title,this,0);
        UtilitiesClass.setFont(total,this,0);
        UtilitiesClass.setFont(price,this,0);
        UtilitiesClass.setFont(text,this,0);

        if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
            order.setRotation(order.getRotation() +180);
            text.setRotation(text.getRotation()+180);
        }
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,SendCoponActivity.class));
            }
        });

    }
}
