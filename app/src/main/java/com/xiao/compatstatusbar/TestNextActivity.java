package com.xiao.compatstatusbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

import com.xiao.compatstatusbar.base.CompatStatusBarActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by desaco on 2018/10/25.
 *
 * com.xiao.compatstatusbar.TestNextActivity
 */

public class TestNextActivity extends CompatStatusBarActivity {

    private ViewPager mViewpager;
    private ArrayList<Fragment> mFragmentList;
    private MyViewPagerAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_next);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_next);
        int color = 0xff69ADDA;//ffffff 69ADDA
        toolbar.setBackgroundColor(color);
        setImmersiveStatusBar(true, color);

        initData();
    }

    private TestNextFragment fragment1;
    private TestNextFragment fragment2;
    private TestNextFragment fragment3;

    private void initData(){

        fragment1 =  TestNextFragment.getInstance("第1111个 ViewPager_Fragment");
        fragment2 =  TestNextFragment.getInstance("第2222个 ViewPager_Fragment");
        fragment3 =  TestNextFragment.getInstance("第3333个 ViewPager_Fragment");
        //view_pager
        mViewpager = (ViewPager)findViewById(R.id.view_pager);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(fragment1);
        mFragmentList.add(fragment2);
        mFragmentList.add(fragment3);

        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewpager.setAdapter(mAdapter);
    }
    private void show() {

    }

    public class MyViewPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> list;

        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }
    }
}
