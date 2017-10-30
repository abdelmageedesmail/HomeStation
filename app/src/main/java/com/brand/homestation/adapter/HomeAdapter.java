package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.Locale;

/**
 * Created by abdelmageed on 12/10/17.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder>{

    Context context;
    public HomeAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.home_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.innerRecycler.setAdapter(new InnerHomeAdapter(context));
        holder.innerRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView newMeal,menu;
        RecyclerView innerRecycler;

        public MyHolder(View itemView) {
            super(itemView);
            newMeal=(TextView) itemView.findViewById(R.id.newMeal);
            menu=(TextView) itemView.findViewById(R.id.menu);
            innerRecycler=(RecyclerView) itemView.findViewById(R.id.recyclerInnerHome);
            if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
                menu.setGravity(Gravity.START);
                newMeal.setGravity(Gravity.END);
            }
            UtilitiesClass.setFont(newMeal,context,0);
            UtilitiesClass.setFont(menu,context,0);
        }
    }
}
