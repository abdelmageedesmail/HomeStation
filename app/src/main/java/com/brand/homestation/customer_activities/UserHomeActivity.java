package com.brand.homestation.customer_activities;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.brand.homestation.R;
import com.brand.homestation.activities.SearchActivity;
import com.brand.homestation.activities.SettingActivity;
import com.brand.homestation.adapter.MenuAdapter;
import com.brand.homestation.adapter.MyOrdersAdapter;
import com.brand.homestation.adapter.NavigationDrawerAdapter;
import com.brand.homestation.adapter.SearchAdapter;
import com.brand.homestation.adapter.UserHomeAdapter;
import com.brand.homestation.models.NavDrawerItem;
import com.brand.homestation.trader_activities.AddMealActivity;
import com.brand.homestation.trader_activities.HomeTraderActivity;
import com.brand.homestation.trader_activities.OrdersActivity;
import com.brand.homestation.trader_activities.TraderMenuActivity;
import com.brand.homestation.utiles.UtilitiesClass;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class UserHomeActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener{


    private ArrayList<String> mTitles = new ArrayList<>();
    private MenuAdapter mMenuAdapter;
    private ViewHolder mViewHolder;
    BannerSlider bs_banner_slider;
    List<Banner> banners = new ArrayList<>();
    RecyclerView recyclerUserHome;
    TextView newMeals,more;
    ImageView notification;
    LinearLayout search;
    MaterialSearchView search_view;
    EditText isearchFor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.titleUser)));
        bs_banner_slider = (BannerSlider) findViewById(R.id.bs_banner_slider);
        recyclerUserHome = (RecyclerView) findViewById(R.id.recyclerUSerHome);
        newMeals=(TextView) findViewById(R.id.newMeals);
        more=(TextView) findViewById(R.id.more);
        notification=(ImageView) findViewById(R.id.notification);
        search=(LinearLayout) findViewById(R.id.search);
        search_view=(MaterialSearchView) findViewById(R.id.search_view);
        isearchFor=(EditText) findViewById(R.id.isearchFor);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(UserHomeActivity.this, "ZzZzZzZzZzZz...", Toast.LENGTH_SHORT).show();
//                new SearchActivity().show(getSupportFragmentManager(),"search");

              showEditDialog();
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomeActivity.this,CartActivity.class));
            }
        });
        UtilitiesClass.setFont(newMeals,this,0);
        UtilitiesClass.setFont(more,this,0);

        if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
            newMeals.setGravity(Gravity.START);
            more.setGravity(Gravity.END);
        }

        banners.add(new RemoteBanner(""+R.mipmap.group_25));
        bs_banner_slider.setBanners(banners);
        recyclerUserHome.setAdapter(new UserHomeAdapter(this));
        recyclerUserHome.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerUserHome.setNestedScrollingEnabled(false);
        recyclerUserHome.setFocusable(false);
        mViewHolder = new ViewHolder();
        handleMenu();
        handleDrawer();

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserHomeActivity.this,MenuActivity.class));
            }
        });

    }


    private void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        SearchActivity editNameDialogFragment = SearchActivity.newInstance("Some Title");
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        search_view.setMenuItem(item);
        return true;
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


    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        setTitle(mTitles.get(position));
        mMenuAdapter.setViewSelected(position, true);

        switch (position) {
            case 1:
                startActivity(new Intent(this,FamiliesProdusesActivity.class));
                break;
            case 2:startActivity(new Intent(this, Special_product.class));
                break;
            case 3:startActivity(new Intent(this, MyOrdersActivity.class));
                break;
            case 6:startActivity(new Intent(this,SettingActivity.class));
                break;
            case 7:startActivity(new Intent(this,WishListActivity.class));
                break;
        }

        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;
        LinearLayout linearHeader;

        ViewHolder() {
            mDuoDrawerLayout = (DuoDrawerLayout) findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            TextView logout = (TextView) mDuoMenuView.findViewById(R.id.duo_view_footer_text);
            TextView name = (TextView) mDuoMenuView.findViewById(R.id.duo_view_header_text_title);
            TextView email = (TextView) mDuoMenuView.findViewById(R.id.duo_view_header_text_sub_title);
            linearHeader=(LinearLayout) mDuoMenuView.findViewById(R.id.linearHeader);

            linearHeader.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(UserHomeActivity.this,UserProfile.class));
                }
            });
            UtilitiesClass.setFont(logout, UserHomeActivity.this, 0);
            UtilitiesClass.setFont(name, UserHomeActivity.this, 0);
            UtilitiesClass.setFont(email, UserHomeActivity.this, 0);
        }
    }
}
