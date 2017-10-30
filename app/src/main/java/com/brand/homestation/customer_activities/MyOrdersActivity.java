package com.brand.homestation.customer_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.MyOrdersAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

public class MyOrdersActivity extends AppCompatActivity {

    TextView title;
    RecyclerView recyclerOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        recyclerOrders=(RecyclerView) findViewById(R.id.recyclerOrders);
        title=(TextView) findViewById(R.id.title);
        UtilitiesClass.setFont(title,this,0);
        recyclerOrders.setAdapter(new MyOrdersAdapter(this));
        recyclerOrders.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
