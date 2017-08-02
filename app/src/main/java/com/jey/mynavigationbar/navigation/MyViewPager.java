package com.jey.mynavigationbar.navigation;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by jie on 2017/8/2.
 */

public class MyViewPager extends ViewPager {
    private boolean isScrool = true;
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScrool) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScrool) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
    public void setScrool(boolean b) {
        isScrool = b;
    }
}
