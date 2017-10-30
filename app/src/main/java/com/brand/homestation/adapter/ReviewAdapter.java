package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.MyHolder>{
    Context context;

    public ReviewAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rate_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView name,review,date;
        public MyHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.userName);
            review=(TextView) itemView.findViewById(R.id.review);
            date=(TextView) itemView.findViewById(R.id.date);
            UtilitiesClass.setFont(name,context,0);
            UtilitiesClass.setFont(review,context,0);
            UtilitiesClass.setFont(date,context,0);
        }
    }
}
