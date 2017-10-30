package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.models.FavouriteModel;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.ArrayList;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class TraderAdapter extends RecyclerView .Adapter<TraderAdapter.MyHolder>{

    Context context;
    ArrayList<FavouriteModel> arrayList;
    public TraderAdapter(Context context,ArrayList<FavouriteModel> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.trader_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView name,more;
        public MyHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.resturantName);
            more=(TextView) itemView.findViewById(R.id.more);
            UtilitiesClass.setFont(name,context,0);
            UtilitiesClass.setFont(more,context,0);
        }
    }
}
