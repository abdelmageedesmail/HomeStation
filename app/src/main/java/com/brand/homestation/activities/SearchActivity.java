package com.brand.homestation.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.brand.homestation.R;
import com.brand.homestation.adapter.SearchAdapter;
import com.brand.homestation.customer_activities.UserHomeActivity;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 22/10/17.
 */

public class SearchActivity extends DialogFragment{


    public static SearchActivity newInstance(String title) {
        SearchActivity frag = new SearchActivity();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.popup_search,container,false);

        EditText search=(EditText) v.findViewById(R.id.isearchFor);
        RecyclerView recyclerFilter=(RecyclerView) v.findViewById(R.id.searchresult);
        recyclerFilter.setAdapter(new SearchAdapter(getActivity()));
        recyclerFilter.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        UtilitiesClass.setFont(search,getActivity(),0);

        Window window = getActivity().getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.copyFrom(window.getAttributes());
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        wlp.gravity = Gravity.TOP;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        window.setAttributes(wlp);
        return v;
    }
}
