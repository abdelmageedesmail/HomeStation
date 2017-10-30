package com.brand.homestation.activities;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

public class EditPasswordActivity extends AppCompatActivity {

    TextInputLayout inputLayout1,inputLayout2;
    EditText pass,confirmPass;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        inputLayout1=(TextInputLayout) findViewById(R.id.textInput1);
        inputLayout2=(TextInputLayout) findViewById(R.id.textInput2);
        pass=(EditText) findViewById(R.id.et_email);
        confirmPass=(EditText) findViewById(R.id.et_password);
        confirm=(Button) findViewById(R.id.confirm);

        UtilitiesClass.setFont(inputLayout1,this,0);
        UtilitiesClass.setFont(inputLayout2,this,0);
        UtilitiesClass.setFont(pass,this,0);
        UtilitiesClass.setFont(confirmPass,this,0);
        UtilitiesClass.setFont(confirm,this,0);
    }
}
