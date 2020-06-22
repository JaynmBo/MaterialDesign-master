package com.caobo.slideviewdemo.bottomnavigationview;

import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/22 0022
 * Describe:
 **/
public class BottomNavViewDemoFragment extends LazyFragment {

    @BindView(R.id.bottomNav1)
    BottomNavigationView bottomNav1;

    @Override
    protected void initView(View rootView) {



    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_nav_demo;
    }
}
