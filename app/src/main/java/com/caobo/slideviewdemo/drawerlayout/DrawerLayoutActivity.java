package com.caobo.slideviewdemo.drawerlayout;

import android.view.Gravity;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-16.
 */
public class DrawerLayoutActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void initView() {

        // 设置左上角图标["三" —— "←"]效果
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_baseline_account_balance_24);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout;
    }
}
