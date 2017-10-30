package com.brand.homestation.customer_activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.Locale;

public class SendCoponActivity extends AppCompatActivity {

    EditText orderAddress,contact,ifyouHave;
    TextView coupon,text;
    Button orderNow;
    TextView title,total,price;
    FrameLayout order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_copon);
        orderAddress=(EditText) findViewById(R.id.orderAddress);
        contact=(EditText) findViewById(R.id.contact);
        coupon=(TextView) findViewById(R.id.coupon);
        orderAddress=(EditText) findViewById(R.id.orderAddress);
        ifyouHave=(EditText) findViewById(R.id.ifyouHave);
        orderNow=(Button) findViewById(R.id.orderNow);
        title=(TextView) findViewById(R.id.title);
        total=(TextView) findViewById(R.id.total);
        price=(TextView) findViewById(R.id.price);
        text=(TextView) findViewById(R.id.text);
        order=(FrameLayout) findViewById(R.id.order);
        UtilitiesClass.setFont(orderAddress,this,0);
        UtilitiesClass.setFont(contact,this,0);
        UtilitiesClass.setFont(ifyouHave,this,0);
        UtilitiesClass.setFont(coupon,this,0);
        UtilitiesClass.setFont(orderNow,this,0);
        UtilitiesClass.setFont(title,this,0);
        UtilitiesClass.setFont(total,this,0);
        UtilitiesClass.setFont(price,this,0);
        UtilitiesClass.setFont(text,this,0);
        if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
            order.setRotation(order.getRotation() + 180);
            text.setRotation(text.getRotation()+180);
        }
    }
}
