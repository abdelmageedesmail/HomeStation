package com.brand.homestation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;

import com.brand.homestation.R;

public class SettingActivity extends AppCompatActivity {

    SwitchCompat swithNotification,switchLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        swithNotification=(SwitchCompat) findViewById(R.id.swithNotification);
        switchLang=(SwitchCompat) findViewById(R.id.switchLang);
        switchLang.setShowText(true);

    }
}
