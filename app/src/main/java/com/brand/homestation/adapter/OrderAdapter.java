package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 12/10/17.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyHolder>{

    Context context;
    public OrderAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.orders_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.innerRecycler.setAdapter(new InnerOrdersAdapter(context));
        holder.innerRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView date;
        RecyclerView innerRecycler;

        public MyHolder(View itemView) {
            super(itemView);
            date=(TextView) itemView.findViewById(R.id.textDate);
            innerRecycler=(RecyclerView) itemView.findViewById(R.id.innerOrders);
            UtilitiesClass.setFont(date,context,0);
        }
    }
}
