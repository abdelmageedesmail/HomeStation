package com.brand.homestation.customer_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.ReviewAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

public class OpinionsActivity extends AppCompatActivity {
    RecyclerView recyclerReview;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinions);
        recyclerReview=(RecyclerView) findViewById(R.id.recyclerReview);
        title=(TextView) findViewById(R.id.title);
        recyclerReview.setAdapter(new ReviewAdapter(this));
        recyclerReview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        UtilitiesClass.setFont(title,this,0);
    }
}
