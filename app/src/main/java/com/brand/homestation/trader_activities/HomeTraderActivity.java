package com.brand.homestation.trader_activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.brand.homestation.R;
import com.brand.homestation.activities.SettingActivity;
import com.brand.homestation.adapter.HomeAdapter;
import com.brand.homestation.adapter.MenuAdapter;
import com.brand.homestation.adapter.MultiPleImageAdapter;
import com.brand.homestation.customer_activities.UserHomeActivity;
import com.brand.homestation.fragment.FragmentDrawer;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

//FragmentDrawer.FragmentDrawerListener,DuoMenuView.OnMenuClickListener
public class HomeTraderActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener{

    Toolbar toolbar;
    DrawerLayout mDrawerLayout;
    FragmentDrawer drawerFragment;
    private ActionBarDrawerToggle mDrawerToggle;
    RecyclerView recyclerHome;
    private MenuAdapter mMenuAdapter;
    ImageView notification;

    private ViewHolder mViewHolder;

    private ArrayList<String> mTitles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_trader);
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.mDrawer);
//        drawerFragment = (FragmentDrawer)
//                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
//        drawerFragment.setUp(R.id.fragment_navigation_drawer, mDrawerLayout, toolbar);
//        drawerFragment.setDrawerListener(this);
//
        mTitles=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.titleTrader)));
        notification=(ImageView) findViewById(R.id.notification);
        recyclerHome=(RecyclerView) findViewById(R.id.recyclerHome);
        recyclerHome.setAdapter(new HomeAdapter(this));
        recyclerHome.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeTraderActivity.this,Notification_Activity.class));
            }
        });

        mViewHolder = new ViewHolder();

        // Handle toolbar actions


        // Handle menu actions
        handleMenu();

        // Handle drawer actions
        handleDrawer();

    }
//
//    @Override
//    public void onDrawerItemSelected(View view, int position) {
//        switch (position){
//            case 0:startActivity(new Intent(this,HomeTraderActivity.class));
//                break;
//            case 1:startActivity(new Intent(this,AddMealActivity.class));
//                break;
//            case 2:startActivity(new Intent(this,TraderMenuActivity.class));
//                break;
//            case 3:startActivity(new Intent(this,OrdersActivity.class));
//                break;
//        }
//    }

    private void handleToolbar() {
        setSupportActionBar(mViewHolder.mToolbar);
    }

    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();

    }

    private void handleMenu() {
        mMenuAdapter = new MenuAdapter(mTitles);

        mViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);
    }

    @Override
    public void onFooterClicked() {
        Toast.makeText(this, "onFooterClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show();
    }

//

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        // Set the toolbar title
        setTitle(mTitles.get(position));

        // Set the right options selected
        mMenuAdapter.setViewSelected(position, true);

        // Navigate to the right fragment
        switch (position) {
            case 0:startActivity(new Intent(this,HomeTraderActivity.class));
                break;
            case 1:startActivity(new Intent(this,AddMealActivity.class));
                break;
            case 2:startActivity(new Intent(this,TraderMenuActivity.class));
                break;
            case 3:startActivity(new Intent(this,OrdersActivity.class));
                break;
            case 4:startActivity(new Intent(this,TraderAcceptedOrders.class));
                break;
            case 7:startActivity(new Intent(this, SettingActivity.class));
                break;
        }

        // Close the drawer
        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }
    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            TextView logout= (TextView) mDuoMenuView.findViewById(R.id.duo_view_footer_text);
            TextView name= (TextView) mDuoMenuView.findViewById(R.id.duo_view_header_text_title);
            TextView email=(TextView) mDuoMenuView.findViewById(R.id.duo_view_header_text_sub_title);
            LinearLayout linearHeader=(LinearLayout) mDuoMenuView.findViewById(R.id.linearHeader);
            if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
                mDuoDrawerLayout.setGravity(Gravity.END);
            }

            linearHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(HomeTraderActivity.this,TraderProfileActivity.class));
                }
            });
            UtilitiesClass.setFont(logout,HomeTraderActivity.this,0);
            UtilitiesClass.setFont(name,HomeTraderActivity.this,0);
            UtilitiesClass.setFont(email,HomeTraderActivity.this,0);
        }
    }
}
