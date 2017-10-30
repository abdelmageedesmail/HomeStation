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
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.Collections;
import java.util.List;

/**
 * Created by Fehoo on 08/09/2015.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
//
    int[] pic = {R.mipmap.home, R.mipmap.add_meal, R.mipmap.menu ,R.mipmap.menu_1,R.mipmap.about ,R.mipmap.contact,R.mipmap.settings,R.mipmap.privacy,R.mipmap.log_out};

//     R.drawable.help_icon,
    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
        holder.im.setImageResource(pic[position]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView im;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textRow);
            im = (ImageView) itemView.findViewById(R.id.imageView);

            UtilitiesClass.setFont(title,context,0);
        }

    }
}
