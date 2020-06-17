package com.caobo.slideviewdemo.drawerlayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-16.
 * DrawerLayout + Toolbar
 */
public class DrawerLayoutActivity2 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void initView() {
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        // 设置左上角图标["三" —— "←"]效果
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();
        // 添加DrawerLayout监听器，这里根据DrawerLayout的回调方法实现HeaderView的动画效果
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout2;
    }
}
