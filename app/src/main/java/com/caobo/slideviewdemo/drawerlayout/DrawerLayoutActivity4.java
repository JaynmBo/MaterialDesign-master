package com.caobo.slideviewdemo.drawerlayout;

import android.view.View;
import android.view.ViewGroup;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-16.
 * 仿QQ个人中心侧滑效果
 */
public class DrawerLayoutActivity4 extends BaseActivity {

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;


    @Override
    protected void initView() {
        StatusBarUtils.setTransparent(this);
        // 设置 NavigationView 全屏展示
        ViewGroup.LayoutParams mLayoutParams = navigationView.getLayoutParams();
        int width = getResources().getDisplayMetrics().widthPixels;
        mLayoutParams.width = width;
        navigationView.setLayoutParams(mLayoutParams);

        // 设置不允许 NavigationMenuView 滚动
        NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);
        }

        // 添加DrawerLayout监听器，这里根据DrawerLayout的回调方法实现HeaderView的动画效果
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // 抽屉状态发生变化时调用
                // 主页内容
                View contentView = drawerLayout.getChildAt(0);
                // 侧边栏
                View menuView = drawerView;
                // slideOffset 值默认是0~1
                contentView.setTranslationX(menuView.getMeasuredWidth() * slideOffset);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout4;
    }
}
