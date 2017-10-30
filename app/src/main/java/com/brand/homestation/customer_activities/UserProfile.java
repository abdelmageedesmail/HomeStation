package com.brand.homestation.customer_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

public class UserProfile extends AppCompatActivity {

    TextView name,tvPhone,phone,tvAddress,address,tvOnline,tvEmail,email;
    Button update,MyMeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        name=(TextView) findViewById(R.id.title);
        tvPhone=(TextView) findViewById(R.id.ivPhone);
        phone=(TextView) findViewById(R.id.phone);
        tvAddress=(TextView) findViewById(R.id.ivAddress);
        address=(TextView) findViewById(R.id.address);

        tvEmail=(TextView) findViewById(R.id.ivEmail);
        email=(TextView) findViewById(R.id.email);
        update=(Button) findViewById(R.id.update);
        MyMeal=(Button) findViewById(R.id.myMeal);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfile.this,UpdateUserProfile.class));
            }
        });
        setUpFonts();
    }

    private void setUpFonts(){
        UtilitiesClass.setFont(name,this,0);
        UtilitiesClass.setFont(tvPhone,this,0);
        UtilitiesClass.setFont(phone,this,0);
        UtilitiesClass.setFont(tvAddress,this,0);
        UtilitiesClass.setFont(address,this,0);
        UtilitiesClass.setFont(tvEmail,this,0);
        UtilitiesClass.setFont(email,this,0);
        UtilitiesClass.setFont(update,this,0);
        UtilitiesClass.setFont(MyMeal,this,0);
    }
}
