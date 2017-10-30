package com.brand.homestation.trader_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.NotificationAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

public class Notification_Activity extends AppCompatActivity {

    TextView orderTitle;
    RecyclerView recyclerNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_);
        orderTitle=(TextView) findViewById(R.id.orderTitle);
        recyclerNotification=(RecyclerView) findViewById(R.id.notificationTrader);
        recyclerNotification.setAdapter(new NotificationAdapter(this));
        recyclerNotification.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        UtilitiesClass.setFont(orderTitle,this,0);

    }
}
