package com.caobo.slideviewdemo.drawerlayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-16.
 * 仿QQ个人中心侧滑效果
 */
public class DrawerLayoutActivity4 extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    MovingImageView movingImageView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void initView() {
        StatusBarUtils.setTransparent(this);
        movingImageView = navigationView.getHeaderView(0).findViewById(R.id.movingImageView);

        // 设置左上角图标["三" —— "←"]效果
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        // 设置不允许 NavigationMenuView 滚动
        NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        if (navigationMenuView != null) {
            navigationMenuView.setVerticalScrollBarEnabled(false);
        }

        // 添加DrawerLayout监听器，这里根据DrawerLayout的回调方法实现HeaderView的动画效果
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                movingImageView.pauseMoving();
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                if (movingImageView.getMovingState() == MovingViewAnimator.MovingState.stop) {
                    movingImageView.startMoving();
                } else if (movingImageView.getMovingState() == MovingViewAnimator.MovingState.pause) {
                    movingImageView.resumeMoving();
                }
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                movingImageView.stopMoving();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                if (movingImageView.getMovingState() == MovingViewAnimator.MovingState.stop) {
                    movingImageView.startMoving();
                } else if (movingImageView.getMovingState() == MovingViewAnimator.MovingState.pause) {
                    movingImageView.resumeMoving();
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.group_item_github:
                        Toast.makeText(DrawerLayoutActivity4.this,"项目主页",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.group_item_more:
                        Toast.makeText(DrawerLayoutActivity4.this,"更多内容",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.group_item_qr_code:
                        Toast.makeText(DrawerLayoutActivity4.this,"二维码",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.group_item_share_project:
                        Toast.makeText(DrawerLayoutActivity4.this,"分享项目",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_model:
                        Toast.makeText(DrawerLayoutActivity4.this,"夜间模式",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_about:
                        Toast.makeText(DrawerLayoutActivity4.this,"关于",Toast.LENGTH_SHORT).show();
                        break;
                }
                item.setCheckable(false);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_drawerlayout4;
    }
}
