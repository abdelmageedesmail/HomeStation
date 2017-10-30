package com.brand.homestation.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brand.homestation.R;
import com.brand.homestation.adapter.TraderAdapter;
import com.brand.homestation.db.TraderDbHelper;
import com.brand.homestation.models.FavouriteModel;

import java.util.ArrayList;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class TraderFragment extends Fragment{

    RecyclerView recyclerFavTrader;
    SQLiteDatabase db;
    ArrayList<FavouriteModel> arrayList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.trader_fragment,container,false);
        recyclerFavTrader=(RecyclerView) v.findViewById(R.id.recyclerTrader);
        TraderDbHelper dbHelper=new TraderDbHelper(getActivity());
        db = dbHelper.getWritableDatabase();
        arrayList=dbHelper.getAllCotacts();
        if (arrayList.size()>0) {
            recyclerFavTrader.setAdapter(new TraderAdapter(getActivity(),arrayList));
            recyclerFavTrader.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        }
        return v;
    }
}
