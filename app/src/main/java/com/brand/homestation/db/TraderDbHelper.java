package com.brand.homestation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.brand.homestation.models.FavouriteModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by abdelmageed on 19/10/17.
 */

public class TraderDbHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "contacts";
    public static final String CONTACTS_COLUMN_ID = "id";
    public static final String CONTACTS_COLUMN_NAME = "name";
    public static final String CONTACTS_COLUMN_PHONE = "image";
    public static final String CONTACTS_COLUMN_Address = "address";
    public static final String CONTACTS_COLUMN_price = "price";
    public static final String CONTACTS_COLUMN_discount = "discount";
    public static final String ResturantName="resturantName";

    public TraderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table contacts " +
                        "(id integer primary key, name text, phoneNumber text, address text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + Contract.OffersTable.TABLENAME);

        onCreate(db);
    }


    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    public boolean insertContact (String id,String name, String phone,String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name", name);
//        contentValues.put("image", image);
        contentValues.put("phoneNumber", phone);
        contentValues.put("address", address);

        db.insert("contacts", null, contentValues);
        return true;
    }

    public ArrayList<FavouriteModel> getAllCotacts() {
        ArrayList<FavouriteModel> array_list = new ArrayList<FavouriteModel>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String id = res.getString(res.getColumnIndex(CONTACTS_COLUMN_ID));
            String name = res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME));
            String offerImg = res.getString(res.getColumnIndex(CONTACTS_COLUMN_PHONE));
            String address = res.getString(res.getColumnIndex(CONTACTS_COLUMN_Address));
            FavouriteModel model=new FavouriteModel();
            model.setId(id);
            model.setName(name);
            model.setPhone(offerImg);
            model.setAddress(address);
            array_list.add(model);
            res.moveToNext();
        }
        return array_list;
    }
    public Integer deleteContact (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
}

