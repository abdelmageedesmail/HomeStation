package com.brand.homestation.activities;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

public class ChooseLoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv_pass,tv_trader,tv_customer;
    ImageView iv_trader,iv_customer,iv_arraw;
    public static int comminFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login);
        setUpReference();

//        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE,},
//                1);
    }

    private void setUpReference(){
        tv_pass=(TextView) findViewById(R.id.tv_pass);
        tv_trader=(TextView) findViewById(R.id.tv_trader);
        tv_customer=(TextView) findViewById(R.id.tv_customer);
        iv_arraw=(ImageView) findViewById(R.id.iv_pass);
        iv_trader=(ImageView) findViewById(R.id.trader);
        iv_customer=(ImageView) findViewById(R.id.customer);
        iv_arraw.setOnClickListener(this);
        iv_customer.setOnClickListener(this);
        iv_trader.setOnClickListener(this);
        UtilitiesClass.setFont(tv_trader,this,0);
        UtilitiesClass.setFont(tv_customer,this,0);
        UtilitiesClass.setFont(tv_pass,this,0);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.iv_pass:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.customer:
                comminFrom=1;
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;

            case R.id.trader:
                comminFrom=2;
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
        }
    }
}
