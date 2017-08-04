package com.jey.mynavigationbar.navigation;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.jey.mynavigationbar.R;

import java.util.ArrayList;
import java.util.List;

/**底部导航栏控件（创建传入的上下文须得是FragmentActivity下的）
 *
 * Created by jie on 2017/8/2.
 */

public class NavigationBar extends FrameLayout {
    private MyViewPager mViewPager;
    private TabLayout mTabLayout;
    private MyAdapter mAdapter;
    private List<Fragment> mFragments;
    private List<View> mViews;

    public NavigationBar(Context context) {
        this(context,null);
    }

    public NavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_navigation_bar,this,true);
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.viewpager);

        mFragments = new ArrayList<>();
        mViews = new ArrayList<>();

        mAdapter = new MyAdapter(((FragmentActivity)context).getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        initTab();
        initEvents();
    }

    /**
     * 设置ViewPager的滑动功能
     */
    public void setViewPagerScroll(boolean isScrool) {
        mViewPager.setScroll(isScrool);
    }

    private void initEvents() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                for (int i = 0;i < mFragments.size();i++) {
                    if (tab == mTabLayout.getTabAt(i)) {
                        mViewPager.setCurrentItem(i,false);
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    /**添加Fragment
     * @param fragment
     */
    public void addFragments(Fragment fragment) {
        mFragments.add(fragment);

    }

    /**添加Tab
     * @param view
     */
    public void addTab(View view) {
        mViews.add(view);
    }


    /**
     * 初始化Tab
     */
    public void initTab() {
        mAdapter.notifyDataSetChanged();
        for (int i = 0;i < mFragments.size();i++) {
            mTabLayout.getTabAt(i).setCustomView(mViews.get(i));
        }
    }

    class MyAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragments;

        /**
         * @param fm        FragmentManager
         * @param fragments fragment集合
         */
        public MyAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }


}
