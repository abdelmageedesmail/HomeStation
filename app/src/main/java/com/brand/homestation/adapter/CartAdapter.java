package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.utiles.UtilitiesClass;

/**
 * Created by abdelmageed on 22/10/17.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyHolder>{

    Context context;
    int j = 1;
    public CartAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j++;
                holder.number.setText("" + j);
            }
        });



        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j--;
                holder.number.setText("" + j);
                if (j <= 0) {
                    j = 1;
                    holder.number.setText("1");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView name,resturantName,mealDescription,plus,minus,quantity,price,number;
        public MyHolder(View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.mealName);
            resturantName=(TextView) itemView.findViewById(R.id.resturantName);
            mealDescription=(TextView) itemView.findViewById(R.id.resturantDescription);
            plus=(TextView) itemView.findViewById(R.id.quantity);
            minus=(TextView) itemView.findViewById(R.id.plus);
            quantity=(TextView) itemView.findViewById(R.id.minus);
            price=(TextView) itemView.findViewById(R.id.price);
            number=(TextView) itemView.findViewById(R.id.number);
            UtilitiesClass.setFont(name,context,0);
            UtilitiesClass.setFont(resturantName,context,0);
            UtilitiesClass.setFont(mealDescription,context,0);
            UtilitiesClass.setFont(plus,context,0);
            UtilitiesClass.setFont(minus,context,0);
            UtilitiesClass.setFont(quantity,context,0);
            UtilitiesClass.setFont(price,context,0);
            UtilitiesClass.setFont(number,context,0);
        }
    }
}
