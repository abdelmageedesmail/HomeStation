package com.brand.homestation.trader_activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class TragerUpdateProfile extends AppCompatActivity {

    TextView name,address,state,email,phone,date,deliverPercent,title,delete;
    EditText etName,etAddress,etEmail,etPhone,etDate;
    Spinner spState;
    DiscreteSeekBar mSeekBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trager_update_profile);
        name=(TextView) findViewById(R.id.resturantName);
//        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        address=(TextView) findViewById(R.id.address);
        state=(TextView) findViewById(R.id.state);
        email=(TextView) findViewById(R.id.tvEmail);
        phone=(TextView) findViewById(R.id.phone);
        date=(TextView) findViewById(R.id.date);
        deliverPercent=(TextView) findViewById(R.id.deliverPercent);
        title=(TextView) findViewById(R.id.title);
        delete=(TextView) findViewById(R.id.delete);
        etName=(EditText) findViewById(R.id.etName);
        etAddress=(EditText) findViewById(R.id.etAddress);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etPhone=(EditText) findViewById(R.id.etPhone);
        etDate=(EditText) findViewById(R.id.etDate);
        spState=(Spinner) findViewById(R.id.spState);
        mSeekBar=(DiscreteSeekBar) findViewById(R.id.seek);

        setUpFonts();
    }

    private void setUpFonts(){
        UtilitiesClass.setFont(name,this,0);
        UtilitiesClass.setFont(address,this,0);
        UtilitiesClass.setFont(state,this,0);
        UtilitiesClass.setFont(email,this,0);
        UtilitiesClass.setFont(phone,this,0);
        UtilitiesClass.setFont(date,this,0);
        UtilitiesClass.setFont(deliverPercent,this,0);
        UtilitiesClass.setFont(title,this,0);
        UtilitiesClass.setFont(delete,this,0);
        UtilitiesClass.setFont(etName,this,0);
        UtilitiesClass.setFont(etAddress,this,0);
        UtilitiesClass.setFont(etEmail,this,0);
        UtilitiesClass.setFont(etPhone,this,0);
        UtilitiesClass.setFont(etDate,this,0);

    }
}
