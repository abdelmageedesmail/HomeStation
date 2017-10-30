package com.brand.homestation.trader_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.AcceptedOrderAdapter;

public class TraderAcceptedOrders extends AppCompatActivity {

    RecyclerView recyclerAcceptedOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_accepted_orders);
        recyclerAcceptedOrders=(RecyclerView) findViewById(R.id.acceptedOrders);
        recyclerAcceptedOrders.setAdapter(new AcceptedOrderAdapter(this));
        recyclerAcceptedOrders.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
