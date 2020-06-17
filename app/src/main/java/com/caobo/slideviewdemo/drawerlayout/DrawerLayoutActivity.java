package com.caobo.slideviewdemo.drawerlayout;

import android.view.View;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

/**
 * Created by cb
 * on 2020-06-16.
 */
public class DrawerLayoutActivity extends BaseActivity {

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout;
    }


    public void onDrawerLayoutClick1(View view) {
        startActivity(DrawerLayoutActivity1.class);
    }
    public void onDrawerLayoutClick2(View view) {
        startActivity(DrawerLayoutActivity2.class);
    }
    public void onDrawerLayoutClick3(View view) {
        startActivity(DrawerLayoutActivity3.class);
    }
    public void onDrawerLayoutClick4(View view) {
        startActivity(DrawerLayoutActivity4.class);
    }
    public void onDrawerLayoutClick5(View view) {
        startActivity(DrawerLayoutActivity5.class);
    }
}
