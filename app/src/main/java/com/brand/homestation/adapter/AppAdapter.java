package com.brand.homestation.adapter;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brand.homestation.R;

import java.util.List;

/**
 * Created by abdelmageed on 17/10/17.
 */

public class AppAdapter extends ArrayAdapter<ResolveInfo> {
//    private PackageManager pm = null;

    //, List<ResolveInfo> apps
    public AppAdapter(Context context) {
        super(context, R.layout.share_dialog);
//        this.pm = pm;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_dialog, parent, false);
        if (convertView == null) {
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_dialog, parent, false);
        }else{
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.share_dialog, parent, false);
        }

        bindView(position, convertView);

        TextView label = (TextView) convertView.findViewById(R.id.label);
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        int pic[]={R.mipmap.gmail,R.mipmap.twitter,R.mipmap.face_book,R.mipmap.copy_link,R.mipmap.ellipsis,R.mipmap.whats,R.mipmap.instagram,R.mipmap.timbier};
        String text[]={"gmail","twitter","faceBook","copy","ellipsis","whats","insta","timbier"};


        for (int i=0;i<pic.length&&i<text.length;i++){
            label.setText(text[i]);
            icon.setImageResource(pic[i]);
        }
        return (convertView);
    }

//    private View newView(ViewGroup parent) {
//        return
//    }

    private void bindView(int position, View row) {

    }
}
