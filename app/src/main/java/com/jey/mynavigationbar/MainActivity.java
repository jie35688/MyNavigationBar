package com.jey.mynavigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.jey.mynavigationbar.fragment.FirstFragment;
import com.jey.mynavigationbar.fragment.FouthFragment;
import com.jey.mynavigationbar.fragment.SecondFragment;
import com.jey.mynavigationbar.fragment.ThirdFragment;
import com.jey.mynavigationbar.navigation.NavigationBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        navigationBar.addFragments(new FirstFragment());
        navigationBar.addFragments(new SecondFragment());
        navigationBar.addFragments(new ThirdFragment());
        navigationBar.addFragments(new FouthFragment());

        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_main,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_category,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_buycar,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_my,null));
        navigationBar.initTab();//添加完后要initTab
        navigationBar.setViewPagerScrool(false);

    }
}
