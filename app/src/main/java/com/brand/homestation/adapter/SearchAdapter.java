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
 * Created by abdelmageed on 22/10/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder>{
    Context context;
    public SearchAdapter(Context context) {
        this.context=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.search_row,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView searchRow;
        public MyHolder(View itemView) {
            super(itemView);
            searchRow=(TextView) itemView.findViewById(R.id.searchResultRow);
            UtilitiesClass.setFont(searchRow,context,0);
        }
    }
}
