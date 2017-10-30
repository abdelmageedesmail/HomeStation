package com.brand.homestation.utiles;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abdelmageed on 05/10/17.
 */

public class LocaleShared {

    Context context;
    SharedPreferences sharedPreferences;
    String key = "userData";
    private SharedPreferences.Editor edit;
    private String id="id";

    public LocaleShared(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(key,Context.MODE_PRIVATE);

    }

    public void storeId(String text){
        edit = sharedPreferences.edit();
        edit.putString(id,text);
        edit.apply();
    }

    public String getId(){
        sharedPreferences=context.getSharedPreferences(key,Context.MODE_PRIVATE);
        String value=sharedPreferences.getString(id,"null");
        return value;
    }
    public void storeKey(String key,String text){
        edit = sharedPreferences.edit();
        edit.putString(key,text);
        edit.apply();
    }

    public String getKey(String textKey){
        sharedPreferences=context.getSharedPreferences(key,Context.MODE_PRIVATE);
        String value=sharedPreferences.getString(textKey,"null");
        return value;
    }

}
