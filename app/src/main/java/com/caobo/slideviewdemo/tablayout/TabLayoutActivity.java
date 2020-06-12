package com.caobo.slideviewdemo.tablayout;

import android.os.Bundle;

import com.caobo.slideviewdemo.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by cb
 * on 2020-06-12.
 */
public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private String mTitles[] = {
            "西安", "头条推荐", "生活", "娱乐八卦", "体育",
            "段子", "美食", "电影", "科技", "搞笑",
            "社会", "财经", "时尚", "汽车", "军事",
            "小说", "育儿", "职场", "萌宠", "游戏",
            "健康", "动漫", "互联网"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        tabLayout = findViewById(R.id.tabLayout);
        // 设置TAB滚动显示
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        // 设置选中下划线颜色
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimary, null));
        // 设置文本字体颜色[未选中颜色、选中颜色]
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorBlack, null),
                getResources().getColor(R.color.colorPrimary, null));
        // 设置下划线高度，已弃用，建议在XML中使用app:tabIndicatorHeight属性设置
        tabLayout.setSelectedTabIndicatorHeight(10);
        // 设置下划线跟文本宽度一致
        tabLayout.setTabIndicatorFullWidth(false);
        // 添加TAB标签
        for (String mTitle : mTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitle));
        }


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(final TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
