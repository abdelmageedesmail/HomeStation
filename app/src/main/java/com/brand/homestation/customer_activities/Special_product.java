package com.brand.homestation.customer_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.UserHomeAdapter;

public class Special_product extends AppCompatActivity {

    RecyclerView newMealLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_product);

        newMealLists=(RecyclerView) findViewById(R.id.newMealLists);
        newMealLists.setAdapter(new UserHomeAdapter(this));
        newMealLists.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
