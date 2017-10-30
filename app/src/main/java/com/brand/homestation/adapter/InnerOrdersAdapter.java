package com.brand.homestation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.trader_activities.AddMealActivity;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 12/10/17.
 */

public class InnerOrdersAdapter extends RecyclerView.Adapter<InnerOrdersAdapter.MyHolder>{

    Context context;
    public static boolean isFrom;
    public InnerOrdersAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.inner_order_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView title,price,userName,time;
        ImageView accept,reject;

        public MyHolder(View itemView) {
            super(itemView);
            title=(TextView) itemView.findViewById(R.id.title);
            price=(TextView) itemView.findViewById(R.id.price);
            userName=(TextView) itemView.findViewById(R.id.userName);
            time=(TextView) itemView.findViewById(R.id.time);
            accept=(ImageView) itemView.findViewById(R.id.accept);
            reject=(ImageView) itemView.findViewById(R.id.reject);
            UtilitiesClass.setFont(title,context,0);
            UtilitiesClass.setFont(price,context,0);
            UtilitiesClass.setFont(userName,context,0);
            UtilitiesClass.setFont(time,context,0);
        }
    }
}
