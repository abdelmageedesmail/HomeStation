package com.brand.homestation.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 12/10/17.
 */

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyHolder>{

    Context context;
    public MyOrdersAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.user_order_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        if (position%2!=0){
            holder.card.setBackgroundColor(Color.parseColor("#f4f4f4"));
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView userName,mealName,time,mealState;
        LinearLayout card;

        public MyHolder(View itemView) {
            super(itemView);
            userName=(TextView) itemView.findViewById(R.id.userName);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            time=(TextView) itemView.findViewById(R.id.time);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            mealState=(TextView) itemView.findViewById(R.id.mealState);
            card=(LinearLayout) itemView.findViewById(R.id.card);
            UtilitiesClass.setFont(userName,context,0);
            UtilitiesClass.setFont(mealName,context,0);
            UtilitiesClass.setFont(time,context,0);
            UtilitiesClass.setFont(mealState,context,0);
        }
    }
}
