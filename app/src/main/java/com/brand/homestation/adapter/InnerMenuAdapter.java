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
 * Created by abdelmageed on 12/10/17.
 */

public class InnerMenuAdapter extends RecyclerView.Adapter<InnerMenuAdapter.MyHolder>{

    Context context;
    public InnerMenuAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.inner_menu_item,parent,false);
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

        TextView mealName,mealPrice,mealDiscription,more;

        public MyHolder(View itemView) {
            super(itemView);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            mealPrice=(TextView) itemView.findViewById(R.id.mealPrice);
            mealDiscription=(TextView) itemView.findViewById(R.id.mealDescription);
            more=(TextView) itemView.findViewById(R.id.more);
            UtilitiesClass.setFont(mealName,context,0);
            UtilitiesClass.setFont(mealPrice,context,0);
            UtilitiesClass.setFont(mealDiscription,context,0);
            UtilitiesClass.setFont(more,context,0);
        }
    }
}
