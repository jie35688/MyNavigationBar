package com.jey.mynavigationbar.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.jey.mynavigationbar.R;

/**
 * Created by jie on 2017/8/2.
 */

public class MyViewPager extends ViewPager {
    private boolean isScroll = true;
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.MyViewPager);
         /*获取布局中设置的属性*/
        if (array != null) {
            isScroll = array.getBoolean(R.styleable.MyViewPager_isScroll,true);
            array.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScroll) {
            return super.onTouchEvent(ev);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScroll) {
            return super.onInterceptTouchEvent(ev);
        }
        return false;
    }
    public void setScroll(boolean b) {
        isScroll = b;
    }
}
