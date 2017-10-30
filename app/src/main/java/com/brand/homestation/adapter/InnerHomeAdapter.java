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

public class InnerHomeAdapter  extends RecyclerView.Adapter<InnerHomeAdapter.MyHolder>{

    Context context;
    public static boolean isFrom;
    public InnerHomeAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.inner_home_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFrom=true;
                context.startActivity(new Intent(context, AddMealActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView mealName,mealPrice,mealDiscription,more;
        ImageView edit,delet;

        public MyHolder(View itemView) {
            super(itemView);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            mealPrice=(TextView) itemView.findViewById(R.id.mealPrice);
            mealDiscription=(TextView) itemView.findViewById(R.id.mealDescription);
            more=(TextView) itemView.findViewById(R.id.more);
            edit=(ImageView) itemView.findViewById(R.id.edit);
            delet=(ImageView) itemView.findViewById(R.id.delete);
            UtilitiesClass.setFont(mealName,context,0);
            UtilitiesClass.setFont(mealPrice,context,0);
            UtilitiesClass.setFont(mealDiscription,context,0);
            UtilitiesClass.setFont(more,context,0);
        }
    }
}
