package com.brand.homestation.customer_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.MenuUserAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView=(RecyclerView) findViewById(R.id.menuUser);
        title=(TextView) findViewById(R.id.title);
        UtilitiesClass.setFont(title,this,0);
        recyclerView.setAdapter(new MenuUserAdapter(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }
}
