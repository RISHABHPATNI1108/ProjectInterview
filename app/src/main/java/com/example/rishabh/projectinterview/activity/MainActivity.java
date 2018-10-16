package com.example.rishabh.projectinterview.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.rishabh.projectinterview.fragments.ChatFragment;
import com.example.rishabh.projectinterview.R;
import com.example.rishabh.projectinterview.fragments.CodesFragment;
import com.example.rishabh.projectinterview.fragments.QnAFragment;
import com.example.rishabh.projectinterview.fragments.ThreadsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar mTopToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mTopToolbar);

        tabLayout =  findViewById(R.id.tabs);
        viewPager =  findViewById(R.id.pager);
        tabLayout.addTab(tabLayout.newTab().setText("Live Chat"));
        tabLayout.addTab(tabLayout.newTab().setText("Theads"));
        tabLayout.addTab(tabLayout.newTab().setText("QnA"));
        tabLayout.addTab(tabLayout.newTab().setText("Codes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(-1);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onClick(View v) {

    }


    public class PageAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        PageAdapter(FragmentManager fm, int numTabs) {
            super(fm);
            this.mNumOfTabs = numTabs;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ChatFragment();
                case 1:
                    return new ThreadsFragment();
                case 2:
                    return new QnAFragment();
                case 3:
                    return new CodesFragment();
                default:
                    return null;
            }
        }



        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
