package com.brand.homestation.trader_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.OrderAdapter;

public class OrdersActivity extends AppCompatActivity {

    TextView orderTitle;
    RecyclerView recyclerOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        orderTitle=(TextView) findViewById(R.id.orderTitle);
        recyclerOrders=(RecyclerView) findViewById(R.id.recyclerOrders);

        recyclerOrders.setAdapter(new OrderAdapter(this));
        recyclerOrders.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}
