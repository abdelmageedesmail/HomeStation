package com.brand.homestation.customer_activities;

import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.brand.homestation.R;
import com.brand.homestation.adapter.UserHomeAdapter;
import com.brand.homestation.db.DbHelper;
import com.brand.homestation.db.TraderDbHelper;
import com.brand.homestation.trader_activities.TraderMenuActivity;
import com.brand.homestation.utiles.UtilitiesClass;

public class TraderProfileActivity extends AppCompatActivity {

    TextView name,phone,txtPhone,state,location,option,num,newMeal,more;
    RecyclerView recyclerProduct;

    ImageView rate,wishList;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trader_profile2);
        name=(TextView) findViewById(R.id.traderName);
        phone=(TextView) findViewById(R.id.phone);
        txtPhone=(TextView) findViewById(R.id.phoneNum);
        state=(TextView) findViewById(R.id.state);
        location=(TextView) findViewById(R.id.address);
        option=(TextView) findViewById(R.id.option);
        num=(TextView) findViewById(R.id.oponionNum);
        newMeal=(TextView) findViewById(R.id.more);
        more=(TextView) findViewById(R.id.newMeals);
        rate=(ImageView) findViewById(R.id.add_rate);
        wishList=(ImageView) findViewById(R.id.add_favourite);

        final TraderDbHelper dbHelper = new TraderDbHelper(TraderProfileActivity.this);
        db = dbHelper.getWritableDatabase();

        wishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertContact("1",name.getText().toString(),txtPhone.getText().toString(),location.getText().toString());
                if (dbHelper.insertContact("1",name.getText().toString(),txtPhone.getText().toString(),location.getText().toString())){
                    Toast.makeText(TraderProfileActivity.this, "done", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerProduct=(RecyclerView) findViewById(R.id.recyclerUSerHome);
        recyclerProduct.setAdapter(new UserHomeAdapter(this));
        recyclerProduct.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerProduct.setNestedScrollingEnabled(false);
        recyclerProduct.setFocusable(false);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(TraderProfileActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.rate_dialog);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                Window window = dialog.getWindow();
                lp.copyFrom(window.getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(lp);
                RatingBar ratingBar=(RatingBar) dialog.findViewById(R.id.ratingBar);
                TextView add=(TextView) dialog.findViewById(R.id.addRate);
                TextInputLayout textInput1=(TextInputLayout) dialog.findViewById(R.id.textInput1);
                EditText et_oponion=(EditText) dialog.findViewById(R.id.et_oponion);
                Button addRate=(Button) dialog.findViewById(R.id.add);
                Button cancel=(Button) dialog.findViewById(R.id.cancel);
                UtilitiesClass.setFont(add,TraderProfileActivity.this,0);
                UtilitiesClass.setFont(textInput1,TraderProfileActivity.this,0);
                UtilitiesClass.setFont(et_oponion,TraderProfileActivity.this,0);
                UtilitiesClass.setFont(addRate,TraderProfileActivity.this,0);
                UtilitiesClass.setFont(cancel,TraderProfileActivity.this,0);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        UtilitiesClass.setFont(name,this,0);
        UtilitiesClass.setFont(phone,this,0);
        UtilitiesClass.setFont(txtPhone,this,0);
        UtilitiesClass.setFont(state,this,0);
        UtilitiesClass.setFont(location,this,0);
        UtilitiesClass.setFont(option,this,0);
        UtilitiesClass.setFont(num,this,0);
        UtilitiesClass.setFont(newMeal,this,0);
        UtilitiesClass.setFont(more,this,0);

    }
}
