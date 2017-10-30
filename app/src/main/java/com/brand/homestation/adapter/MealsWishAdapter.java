package com.brand.homestation.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.customer_activities.ProductDetailsActivity;
import com.brand.homestation.customer_activities.WishListActivity;
import com.brand.homestation.db.DbHelper;
import com.brand.homestation.models.FavouriteModel;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.ArrayList;

/**
 * Created by abdelmageed on 16/10/17.
 */

public class MealsWishAdapter extends RecyclerView.Adapter<MealsWishAdapter.MyHolder>{
    Context context;
    ArrayList<FavouriteModel> arrayList;
    SQLiteDatabase db;
    public MealsWishAdapter(Context context,ArrayList<FavouriteModel> arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.meals_wish_item,parent,false);
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
        holder.mealName.setText(arrayList.get(position).getName());
        holder.resturantName.setText(arrayList.get(position).getResturantName());
        holder.mealPrice.setText(arrayList.get(position).getPrice());

        final DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteContact(1);
                context.startActivity(new Intent(context, WishListActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView mealName,mealPrice,resturantName,more;
        ImageView delete;
        public MyHolder(View itemView) {
            super(itemView);
            mealName=(TextView) itemView.findViewById(R.id.mealName);
            mealPrice=(TextView) itemView.findViewById(R.id.mealPrice);
            resturantName=(TextView) itemView.findViewById(R.id.resturantName);
            more=(TextView) itemView.findViewById(R.id.more);
            delete=(ImageView) itemView.findViewById(R.id.delete);

            UtilitiesClass.setFont(mealName,context,0);
            UtilitiesClass.setFont(mealPrice,context,0);
            UtilitiesClass.setFont(resturantName,context,0);
            UtilitiesClass.setFont(more,context,0);

        }
    }
}
