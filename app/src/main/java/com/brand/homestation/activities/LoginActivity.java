package com.brand.homestation.activities;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.customer_activities.UserHomeActivity;
import com.brand.homestation.trader_activities.HomeTraderActivity;
import com.brand.homestation.trader_activities.TraderMenuActivity;
import com.brand.homestation.utiles.UtilitiesClass;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout inputLayout1,inputLayout2;
    EditText et_email,et_pass;
    TextView tv_forgetPass,tv_register;
    Button login;
    ImageView imageEmail,imagePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputLayout1=(TextInputLayout) findViewById(R.id.textInput1);
        inputLayout2=(TextInputLayout) findViewById(R.id.textInput2);
        et_email=(EditText) findViewById(R.id.et_email);
        et_pass=(EditText) findViewById(R.id.et_password);
        tv_forgetPass=(TextView) findViewById(R.id.tv_forgetPass);
        tv_register=(TextView) findViewById(R.id.tv_register);
        login=(Button) findViewById(R.id.login);
        imageEmail=(ImageView) findViewById(R.id.imageEmail);
        imagePassword=(ImageView) findViewById(R.id.imagePassword);
        login.setOnClickListener(this);


        et_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b){
                    imagePassword.setImageResource(R.mipmap.passwordlogin);
                    imageEmail.setImageResource(R.mipmap.userlogin);
                }
            }
        });

        et_pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                imageEmail.setImageResource(R.mipmap.userlogin_1);
                imagePassword.setImageResource(R.mipmap.passwordlogin_1);
            }
        });

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterationActivity.class));
            }
        });

        tv_forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
            }
        });
        UtilitiesClass.setFont(et_email,this,0);
        UtilitiesClass.setFont(et_pass,this,0);
        UtilitiesClass.setFont(tv_forgetPass,this,0);
        UtilitiesClass.setFont(tv_register,this,0);
        UtilitiesClass.setFont(login,this,0);
        UtilitiesClass.setFont(inputLayout1,this,0);
        UtilitiesClass.setFont(inputLayout2,this,0);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.login:
                if (ChooseLoginActivity.comminFrom==1){
                    startActivity(new Intent(this, UserHomeActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(this, HomeTraderActivity.class));
                    finish();
                }
                break;
        }
    }
}
