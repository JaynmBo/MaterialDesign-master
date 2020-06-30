package com.caobo.slideviewdemo.coordinatorLayout;

import android.view.View;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class CoordinatorLayoutActivity extends BaseActivity {


    @Override
    protected void initView() {
        setToolbarTitle("CoordinatorLayout");
        setToolBarCallBack();
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_coordinatorlayout;
    }


    public void fabBehaviorClick(View view) {
        startActivity(CoordinatorBehaviorActivity.class);
    }
    public void fabSnackBehaviorClick(View view) {
        startActivity(SnackBarBehaviorActivity.class);
    }
    public void appBarLayoutBehaviorClick(View view) {
        startActivity(AppBarBehaviorActivity.class);
    }
    public void coordinatorBehaviorClick(View view) {
        startActivity(CoordinatorCardViewActivity.class);
    }
    public void collapsingClick(View view) {
        startActivity(CollapsingToolbarLayoutActivity.class);
    }
}
