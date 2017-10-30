package com.brand.homestation.utiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TextInputLayout;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by abdelmageed on 05/10/17.
 */
public class UtilitiesClass {

    public static void setFont(TextView textView, Context context, int fontIndex) {
        Typeface font = null;

        switch (fontIndex) {
            case 0:
                font = Typeface.createFromAsset(context.getResources().getAssets(), "cocon_next_arabic_light.otf");
                break;

        }

        textView.setTypeface(font);
    }

    public static void setFont(RadioButton radioButtons,Context context,int fontIndex){
        Typeface font=null;
        switch (fontIndex){
            case 0:font=Typeface.createFromAsset(context.getResources().getAssets(),"cocon_next_arabic_light.otf");
                break;
        }
        radioButtons.setTypeface(font);
    }

    public static void setFont(TextInputLayout inputLayout, Context context, int fontIndex) {
        Typeface font = null;

        switch (fontIndex) {
            case 0:
                font = Typeface.createFromAsset(context.getResources().getAssets(), "cocon_next_arabic_light.otf");
                break;

        }

        inputLayout.setTypeface(font);
    }


    public static void setFont(EditText editText, Context context, int fontIndex) {
        Typeface font = null;

        switch (fontIndex) {
            case 0:
                font = Typeface.createFromAsset(context.getResources().getAssets(), "cocon_next_arabic_light.otf");
                break;
        }

        editText.setTypeface(font);
    }

    public static void setFont(Button button, Context context, int fontIndex) {
        Typeface font = null;

        switch (fontIndex) {
            case 0:
                font = Typeface.createFromAsset(context.getResources().getAssets(), "cocon_next_arabic_light.otf");
                break;

        }

        button.setTypeface(font);
    }

    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static String mEncodeToBase64(Bitmap image, Bitmap.CompressFormat compressFormat, int quality) {

        ByteArrayOutputStream byteArrayOS = new ByteArrayOutputStream();
        image.compress(compressFormat, quality, byteArrayOS);
        return Base64.encodeToString(byteArrayOS.toByteArray(), Base64.DEFAULT);

    }

}
