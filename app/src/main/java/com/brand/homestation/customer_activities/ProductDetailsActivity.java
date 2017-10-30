package com.brand.homestation.customer_activities;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.brand.homestation.R;
import com.brand.homestation.adapter.AppAdapter;
import com.brand.homestation.adapter.ShareAdapter;
import com.brand.homestation.db.DbHelper;
import com.brand.homestation.models.NavDrawerItem;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView mealName,textNum,resturantName,state,mealPrice,price,opnion,num,mealComponent
            ,mealComponentText,delivery,additonal,additonMeal,additonMeal2,additonMeal3,title;
    ImageView share,rate,showReview,fav;
    AppAdapter adapter;
    LinearLayout show;
    SQLiteDatabase db;


    private static String[] text = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        mealName=(TextView) findViewById(R.id.mealName);
        textNum=(TextView) findViewById(R.id.textNum);
        resturantName=(TextView) findViewById(R.id.resturantName);
        state=(TextView) findViewById(R.id.state);
        mealPrice=(TextView) findViewById(R.id.mealPrice);
        price=(TextView) findViewById(R.id.price);
        opnion=(TextView) findViewById(R.id.opnion);
        num=(TextView) findViewById(R.id.num);
        mealComponent=(TextView) findViewById(R.id.mealComponent);
        mealComponentText=(TextView) findViewById(R.id.mealComponentText);
        delivery=(TextView) findViewById(R.id.delivery);
        additonal=(TextView) findViewById(R.id.additonal);
        additonMeal=(TextView) findViewById(R.id.additonMeal);
        additonMeal2=(TextView) findViewById(R.id.additonMeal2);
        additonMeal3=(TextView) findViewById(R.id.additonMeal3);
        title=(TextView) findViewById(R.id.title);
        share=(ImageView) findViewById(R.id.share);
        rate=(ImageView) findViewById(R.id.rate);
        showReview=(ImageView) findViewById(R.id.showReview);
        fav=(ImageView) findViewById(R.id.fav);
        show=(LinearLayout) findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductDetailsActivity.this,OpinionsActivity.class));
            }
        });



        final DbHelper dbHelper = new DbHelper(ProductDetailsActivity.this);
        db = dbHelper.getWritableDatabase();
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertContact("1",mealName.getText().toString(),mealPrice.getText().toString(),resturantName.getText().toString());
                if (dbHelper.insertContact("1",mealName.getText().toString(),mealPrice.getText().toString(),resturantName.getText().toString())){
                    Toast.makeText(ProductDetailsActivity.this, "done", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(ProductDetailsActivity.this);
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
                UtilitiesClass.setFont(add,ProductDetailsActivity.this,0);
                UtilitiesClass.setFont(textInput1,ProductDetailsActivity.this,0);
                UtilitiesClass.setFont(et_oponion,ProductDetailsActivity.this,0);
                UtilitiesClass.setFont(addRate,ProductDetailsActivity.this,0);
                UtilitiesClass.setFont(cancel,ProductDetailsActivity.this,0);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        text=new String[]{getString(R.string.gmail),getString(R.string.twitter),getString(R.string.face),getString(R.string.copy),getString(R.string.moreShare),getString(R.string.whats),getString(R.string.insta),getString(R.string.timblier)};
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlert();
            }
        });
        setUpFonts();
    }

    private void setUpFonts(){
        UtilitiesClass.setFont(mealName,this,0);
        UtilitiesClass.setFont(textNum,this,0);
        UtilitiesClass.setFont(resturantName,this,0);
        UtilitiesClass.setFont(state,this,0);
        UtilitiesClass.setFont(mealPrice,this,0);
        UtilitiesClass.setFont(price,this,0);
        UtilitiesClass.setFont(opnion,this,0);
        UtilitiesClass.setFont(num,this,0);
        UtilitiesClass.setFont(mealComponent,this,0);
        UtilitiesClass.setFont(mealComponentText,this,0);
        UtilitiesClass.setFont(delivery,this,0);
        UtilitiesClass.setFont(additonal,this,0);
        UtilitiesClass.setFont(additonMeal,this,0);
        UtilitiesClass.setFont(additonMeal2,this,0);
        UtilitiesClass.setFont(additonMeal3,this,0);
        UtilitiesClass.setFont(title,this,0);
    }

    private void showAlert(){
        Dialog dialog=new Dialog(ProductDetailsActivity.this);
        dialog.setContentView(R.layout.shar_popup);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        wlp.copyFrom(window.getAttributes());
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wlp);
        RecyclerView recyclerView=(RecyclerView) dialog.findViewById(R.id.share);
        recyclerView.setAdapter(new ShareAdapter(ProductDetailsActivity.this,getData()));
        recyclerView.setLayoutManager(new GridLayoutManager(ProductDetailsActivity.this,4));
        dialog.show();
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();


        // preparing navigation drawer items
        for (int i = 0; i < text.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(text[i]);
            data.add(navItem);
        }
        return data;
    }
}
