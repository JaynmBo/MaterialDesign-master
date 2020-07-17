package com.caobo.slideviewdemo.coordinatorLayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;

/**
 * Created by cb
 * on 2020-06-30.
 */
public class AppBarBehaviorActivity extends BaseActivity {

    @Override
    protected void initView() {
        StatusBarUtils.setTransparent(this);
        setToolBarCallBack();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_coordinator_collapsinglayout;
    }
}