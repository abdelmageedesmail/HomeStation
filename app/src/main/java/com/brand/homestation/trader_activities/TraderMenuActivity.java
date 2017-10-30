package com.brand.homestation.trader_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.MenuAdapter;
import com.brand.homestation.adapter.MenuTraderAdapter;

public class TraderMenuActivity extends AppCompatActivity {

    RecyclerView recyclerMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_menu);
        recyclerMenu=(RecyclerView) findViewById(R.id.recyclerMenu);
        recyclerMenu.setAdapter(new MenuTraderAdapter(this));
        recyclerMenu.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
