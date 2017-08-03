package com.jey.mynavigationbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.jey.mynavigationbar.fragment.FirstFragment;
import com.jey.mynavigationbar.fragment.FouthFragment;
import com.jey.mynavigationbar.fragment.SecondFragment;
import com.jey.mynavigationbar.fragment.ThirdFragment;
import com.jey.mynavigationbar.navigation.NavigationBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private boolean mBackKeyPressed; //记录是否首次按返回键

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
        //添加自己需要的fragment
        navigationBar.addFragments(new FirstFragment());
        navigationBar.addFragments(new SecondFragment());
        navigationBar.addFragments(new ThirdFragment());
        navigationBar.addFragments(new FouthFragment());
        //添加自己需要的tab,数量要对应于fragment的数量
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_main,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_category,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_buycar,null));
        navigationBar.addTab(LayoutInflater.from(this).inflate(R.layout.tab_my,null));
        navigationBar.initTab();//添加完后要initTab

        //navigationBar.setViewPagerScrool(false);
    }

    @Override
    public void onBackPressed() {
        if(!mBackKeyPressed){
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mBackKeyPressed = true;
            new Timer().schedule(new TimerTask() {//延时两秒，如果超出则擦错第一次按键记录
                @Override
                public void run() {
                    mBackKeyPressed = false;
                }
            }, 2000);
        } else{//退出程序
            this.finish();
            System.exit(0);
        }

    }
}
