package com.brand.homestation.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brand.homestation.R;
import com.brand.homestation.adapter.MealsWishAdapter;
import com.brand.homestation.db.DbHelper;
import com.brand.homestation.models.FavouriteModel;

import java.util.ArrayList;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class ServiceFragment extends Fragment{

    RecyclerView recyclerWish;
    SQLiteDatabase db;
    ArrayList<FavouriteModel> arrayList;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.meals_fragment,container,false);
        recyclerWish=(RecyclerView)v.findViewById(R.id.serviceRecycler);

        DbHelper dbHelper = new DbHelper(getActivity());
        db = dbHelper.getWritableDatabase();

        arrayList=dbHelper.getAllCotacts();

        if (arrayList.size()>0) {
            recyclerWish.setAdapter(new MealsWishAdapter(getActivity(),arrayList));
            recyclerWish.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        }
        return v;
    }
}
