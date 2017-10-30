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
import com.brand.homestation.trader_activities.MapsActivity;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 16/10/17.
 */

public class AcceptedOrderAdapter extends RecyclerView.Adapter<AcceptedOrderAdapter.MyHolder> {

    Context context;
    public AcceptedOrderAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.accepted_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MapsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MyHolder extends RecyclerView.ViewHolder {
       TextView acceptedMealName,accepteduserName,tvPhone,phone;
        ImageView location;
        public MyHolder(View itemView) {
            super(itemView);
            acceptedMealName=(TextView) itemView.findViewById(R.id.acceptedMealName);
            accepteduserName=(TextView) itemView.findViewById(R.id.accepteduserName);
            tvPhone=(TextView) itemView.findViewById(R.id.tvPhone);
            phone=(TextView) itemView.findViewById(R.id.phone);
            location=(ImageView) itemView.findViewById(R.id.location);
            UtilitiesClass.setFont(acceptedMealName,context,0);
            UtilitiesClass.setFont(accepteduserName,context,0);
            UtilitiesClass.setFont(tvPhone,context,0);
            UtilitiesClass.setFont(phone,context,0);

        }
    }
}
