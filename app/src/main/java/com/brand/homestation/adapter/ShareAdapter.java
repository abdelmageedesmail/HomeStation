package com.brand.homestation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.models.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.MyHolder>{

    Context context;
    List<NavDrawerItem> data;
    int pic[]={R.mipmap.gmail,R.mipmap.twitter,R.mipmap.face_book,R.mipmap.copy_link,R.mipmap.ellipsis,R.mipmap.whats,R.mipmap.instagram,R.mipmap.timbier};
    public ShareAdapter(Context context,List<NavDrawerItem> data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.share_dialog,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.image.setImageResource(pic[position]);
        holder.text.setText(data.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;
        public MyHolder(View itemView) {
            super(itemView);
             text= (TextView) itemView.findViewById(R.id.label);
            image= (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}
