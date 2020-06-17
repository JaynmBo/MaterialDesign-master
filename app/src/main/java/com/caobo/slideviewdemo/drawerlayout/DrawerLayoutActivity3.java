package com.caobo.slideviewdemo.drawerlayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-16.
 * DrawerLayout + NavigationView + Toolbar
 */
public class DrawerLayoutActivity3 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void initView() {

        // 设置左上角图标["三" —— "←"]效果
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        // 添加DrawerLayout监听器，这里根据DrawerLayout的回调方法实现HeaderView的动画效果
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        // 设置不允许 NavigationMenuView 滚动
        NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);
        }
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout3;
    }


}
