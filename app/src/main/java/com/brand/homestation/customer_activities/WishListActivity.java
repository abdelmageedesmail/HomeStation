package com.brand.homestation.customer_activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.fragment.ServiceFragment;
import com.brand.homestation.fragment.TraderFragment;
import com.brand.homestation.utiles.UtilitiesClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WishListActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        title=(TextView) findViewById(R.id.title);
        UtilitiesClass.setFont(title,WishListActivity.this,0);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        if (Locale.getDefault().getDisplayLanguage().equals("العربية")) {
            adapter.addFragment(new TraderFragment(), "أسر منتجه");
            adapter.addFragment(new ServiceFragment(), "وجبات");
            viewPager.setAdapter(adapter);
        } else {
            adapter.addFragment(new TraderFragment(), "Families Producers");
            adapter.addFragment(new ServiceFragment(), "Meals");
            viewPager.setAdapter(adapter);
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
