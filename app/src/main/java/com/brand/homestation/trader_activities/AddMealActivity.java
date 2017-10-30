package com.brand.homestation.trader_activities;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.adapter.InnerHomeAdapter;
import com.brand.homestation.adapter.MultiPleImageAdapter;
import com.brand.homestation.utiles.UtilitiesClass;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.ArrayList;

public class AddMealActivity extends AppCompatActivity {

    ImageView add;
    FrameLayout frameLayout;
    TextInputLayout textInputLayout1,textInputLayout2,textInputLayout3;
    EditText name,price,quantity,mealComponent;
    RadioButton newMeal,discount;
    DiscreteSeekBar mSeekBar;
    LinearLayout addAddition,addPhoto;
    TextView txtAddAnthor,additionMeal;
    //-------------------------this for multi ple image declare-------------
    private int IMAGE_REQUEST_CODE = 101;
    private String IMAGE = null;
    public static ArrayList<Bitmap> bitmaps = new ArrayList<>();
    MultiPleImageAdapter prAdapter;
    RecyclerView multiImage;
   //---------------------------------

    ImageView imageAddition;
    String[] meals=null;
    Spinner spinnerMeal;
    public static boolean isFrom;
    Dialog d;
    LinearLayout linearLayout;


    private void setUpFonts(){
        UtilitiesClass.setFont(textInputLayout1,AddMealActivity.this,0);
        UtilitiesClass.setFont(textInputLayout2,AddMealActivity.this,0);
        UtilitiesClass.setFont(textInputLayout3,AddMealActivity.this,0);
        UtilitiesClass.setFont(name,AddMealActivity.this,0);
        UtilitiesClass.setFont(price,AddMealActivity.this,0);
        UtilitiesClass.setFont(quantity,AddMealActivity.this,0);
        UtilitiesClass.setFont(mealComponent,AddMealActivity.this,0);
        UtilitiesClass.setFont(txtAddAnthor,this,0);
        UtilitiesClass.setFont(additionMeal,this,0);
        UtilitiesClass.setFont(newMeal,this,0);
        UtilitiesClass.setFont(discount,this,0);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        add=(ImageView) findViewById(R.id.add);
        frameLayout=(FrameLayout) findViewById(R.id.bgItem);
        textInputLayout1=(TextInputLayout) findViewById(R.id.textInput1);
        textInputLayout2=(TextInputLayout) findViewById(R.id.textInput2);
        textInputLayout3=(TextInputLayout) findViewById(R.id.textInput3);
        name=(EditText) findViewById(R.id.et_mealName);
        price=(EditText) findViewById(R.id.et_mealPrice);
        quantity=(EditText) findViewById(R.id.et_mealquantity);
        mealComponent=(EditText) findViewById(R.id.et_mealComponent);
        newMeal=(RadioButton) findViewById(R.id.newMeal);
        discount=(RadioButton) findViewById(R.id.disount);
        mSeekBar=(DiscreteSeekBar) findViewById(R.id.seek);
        addAddition=(LinearLayout) findViewById(R.id.addAddition);
        txtAddAnthor=(TextView) findViewById(R.id.tv_addAnthor);
        multiImage=(RecyclerView) findViewById(R.id.multiImage);
        spinnerMeal=(Spinner) findViewById(R.id.spinner);
        prAdapter = new MultiPleImageAdapter(this, bitmaps);
        additionMeal=(TextView) findViewById(R.id.additionMeal);
        linearLayout=(LinearLayout) findViewById(R.id.linearEditAddition);
        newMeal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    discount.setChecked(false);
                    mSeekBar.setVisibility(View.GONE);
                }else {
                    newMeal.setChecked(false);
                    mSeekBar.setVisibility(View.VISIBLE);
                }
            }
        });
        discount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    newMeal.setChecked(false);
                    mSeekBar.setVisibility(View.VISIBLE);
                }else {
                    discount.setChecked(false);
                    mSeekBar.setVisibility(View.GONE);
                }
            }
        });

        if (isFrom){

        }else {
            multiImage.setAdapter(prAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            multiImage.setLayoutManager(layoutManager);
            layoutManager.setReverseLayout(true);
        }

        if (InnerHomeAdapter.isFrom){
            linearLayout.setVisibility(View.VISIBLE);
        }

        meals=getResources().getStringArray(R.array.meals);
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, meals);
        spinnerMeal.setAdapter(adapter);
        mSetupPermissions();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetPhotoFromGallery();
            }
        });

        addAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp() ;
            }
        });


        setUpFonts();
    }

    private void showPopUp(){
        d=new Dialog(AddMealActivity.this);
        d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        d.setContentView(R.layout.popup_addation);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = d.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
         addPhoto=(LinearLayout) d.findViewById(R.id.linearplus);
        imageAddition=(ImageView) d.findViewById(R.id.civ_offerPhoto);
        EditText name=(EditText) d.findViewById(R.id.addition_meal_name);
        EditText price=(EditText) d.findViewById(R.id.addition_meal_price);
        Button add=(Button) d.findViewById(R.id.add);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPhoto.setVisibility(View.GONE);
                isFrom=true;
                mGetPhotoFromGallery();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFrom=false;
                d.dismiss();
            }
        });
        d.show();
    }
    private void mSetupPermissions() {
        String permissions[] = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(this, permissions, 1);
    }

    private void mGetPhotoFromGallery() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        startActivityForResult(i, IMAGE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == IMAGE_REQUEST_CODE && data != null) {

            try {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePathColumn[0]);
                String picturePath = c.getString(columnIndex);
                Bitmap bitmapImage = BitmapFactory.decodeFile(picturePath);

                if (isFrom){
                    IMAGE = UtilitiesClass.mEncodeToBase64(bitmapImage, Bitmap.CompressFormat.JPEG, 100);
                    imageAddition.setImageBitmap(bitmapImage);
                    bitmaps.clear();

                }else {
                    bitmaps.add(bitmapImage);
                    prAdapter.notifyDataSetChanged();
                    Log.e("arraySize", "" + bitmaps.size());
                    frameLayout.setVisibility(View.GONE);
                }
                c.close();

            } catch (NullPointerException ex) {
                Log.e("GALLERY_EXCEPTION", "" + ex.getMessage());
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        bitmaps.clear();
        InnerHomeAdapter.isFrom=false;
    }
}
