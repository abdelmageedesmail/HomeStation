package com.brand.homestation.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

public class ForgetPasswordActivity extends AppCompatActivity {

    Button reset;
    TextInputLayout inputLayout1;
    EditText et_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        reset=(Button) findViewById(R.id.reset);
        inputLayout1=(TextInputLayout) findViewById(R.id.textInput1);
        et_email=(EditText) findViewById(R.id.et_email);
        UtilitiesClass.setFont(reset,this,0);
        UtilitiesClass.setFont(inputLayout1,this,0);
        UtilitiesClass.setFont(et_email,this,0);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgetPasswordActivity.this,EnterCodeActivity.class));
            }
        });
    }
}
