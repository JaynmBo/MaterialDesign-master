package com.caobo.slideviewdemo.bottomnavigationview;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import butterknife.BindView;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Administrator on 2020/6/22 0022
 * Describe:
 **/
public class BottomNavViewDemoFragment extends LazyFragment {

    @BindView(R.id.bottomNav2)
    BottomNavigationView bottomNav2;
    @BindView(R.id.bottomNav3)
    BottomNavigationView bottomNav3;

    public static BottomNavViewDemoFragment newInstance() {
        Bundle args = new Bundle();
        BottomNavViewDemoFragment fragment = new BottomNavViewDemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {
        setNavigationListener();
        setNavigationBadge();
    }

    /**
     * 设置BadgeView
     */
    private void setNavigationBadge() {
        BottomNavigationMenuView itemView = (BottomNavigationMenuView) bottomNav3.getChildAt(0);
        new QBadgeView(getActivity()).bindTarget(itemView.getChildAt(0))
                .setBadgeNumber(6)
                .setBadgeGravity(Gravity.TOP | Gravity.END).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {

            }
        });

        new QBadgeView(getActivity()).bindTarget(itemView.getChildAt(1))
                .setBadgeNumber(27)
                .setBadgeGravity(Gravity.TOP | Gravity.END)
                .setBadgeTextColor(Color.YELLOW)
                .setGravityOffset(10, 0, true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {

            }
        });

        new QBadgeView(getActivity()).bindTarget(itemView.getChildAt(2))
                .setBadgeNumber(999)
                .setBadgeGravity(Gravity.TOP | Gravity.END)
                .setExactMode(false).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {

            }
        });

        new QBadgeView(getActivity()).bindTarget(itemView.getChildAt(3))
                .setBadgeNumber(1000)
                .setBadgeGravity(Gravity.TOP | Gravity.END)
                .setExactMode(true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {

            }
        });
        new QBadgeView(getActivity()).bindTarget(itemView.getChildAt(4))
                .setBadgeNumber(9)
                .setBadgeGravity(Gravity.TOP | Gravity.END)
                .setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {

                    }
                });
    }

    /**
     * 设置BottomNavigationView监听事件
     */
    private void setNavigationListener() {
        bottomNav2.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_item_home:
                        bottomNav2.setBackgroundColor(getResources().getColor(R.color.light_yellow));
                        break;
                    case R.id.menu_item_project:
                        bottomNav2.setBackgroundColor(getResources().getColor(R.color.brown));
                        break;
                    case R.id.menu_item_movie:
                        bottomNav2.setBackgroundColor(getResources().getColor(R.color.txt_link_blue));
                        break;
                    case R.id.menu_item_book:
                        bottomNav2.setBackgroundColor(getResources().getColor(R.color.md_lime_700));
                        break;
                    case R.id.menu_item_personal:
                        bottomNav2.setBackgroundColor(getResources().getColor(R.color.md_yellow_500));
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_nav_demo;
    }
}
