package com.brand.homestation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

public class EnterCodeActivity extends AppCompatActivity {
    TextView title,fiveChar;
    EditText et1,et2,et3,et4,et5;
    Button  confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        title=(TextView) findViewById(R.id.title);
        fiveChar=(TextView) findViewById(R.id.fiveChar);
        et1 =(EditText) findViewById(R.id.et1);
        et2=(EditText) findViewById(R.id.et2);
        et3=(EditText) findViewById(R.id.et3);
        et4=(EditText) findViewById(R.id.et4);
        et5=(EditText) findViewById(R.id.et5);
        confirm=(Button) findViewById(R.id.confirm);
        setUpFonts();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUpValidation();
            }
        });
    }


    private void setUpFonts(){
        UtilitiesClass.setFont(title,this,0);
        UtilitiesClass.setFont(fiveChar,this,0);
        UtilitiesClass.setFont(et1,this,0);
        UtilitiesClass.setFont(et2,this,0);
        UtilitiesClass.setFont(et3,this,0);
        UtilitiesClass.setFont(et4,this,0);
        UtilitiesClass.setFont(et5,this,0);
        UtilitiesClass.setFont(confirm,this,0);

    }

    private void setUpValidation(){
        String text1=et1.getText().toString();
        String text2=et2.getText().toString();
        String text3=et3.getText().toString();
        String text4=et4.getText().toString();
        String text5=et5.getText().toString();

        if (text1.equals("")||text1.isEmpty()){
            et1.setError(getString(R.string.empty));
        }else if (text2.equals("")||text2.isEmpty()){
            et2.setError(getString(R.string.empty));
        }else if (text3.equals("")||text3.isEmpty()){
            et3.setError(getString(R.string.empty));
        }else if (text4.equals("")||text4.isEmpty()){
            et4.setError(getString(R.string.empty));
        }else if (text5.equals("")||text5.isEmpty()){
            et5.setError(getString(R.string.empty));
        }else {
            startActivity(new Intent(EnterCodeActivity.this,EditPasswordActivity.class));
        }
    }
}
