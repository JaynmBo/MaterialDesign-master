package com.caobo.slideviewdemo.drawerlayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;

/**
 * Created by cb
 * on 2020-06-17.
 * DrawerLayout基础使用
 */
public class DrawerLayoutActivity1 extends BaseActivity {
    @Override
    protected void initView() {
        StatusBarUtils.setTransparent(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout1;
    }
}
