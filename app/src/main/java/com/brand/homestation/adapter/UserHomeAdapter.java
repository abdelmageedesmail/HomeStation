package com.brand.homestation.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.customer_activities.ProductDetailsActivity;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 16/10/17.
 */

public class UserHomeAdapter extends RecyclerView.Adapter<UserHomeAdapter.MyHolder>{
    Context context;
    public UserHomeAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.user_home_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ProductDetailsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mealName,mealPrice,resturantName,more;
        public MyHolder(View itemView) {
            super(itemView);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            mealPrice=(TextView) itemView.findViewById(R.id.mealPrice);
            resturantName=(TextView) itemView.findViewById(R.id.resturantName);
            more=(TextView) itemView.findViewById(R.id.more);
            UtilitiesClass.setFont(mealName,context,0);
            UtilitiesClass.setFont(mealPrice,context,0);
            UtilitiesClass.setFont(resturantName,context,0);
            UtilitiesClass.setFont(more,context,0);

        }
    }
}
