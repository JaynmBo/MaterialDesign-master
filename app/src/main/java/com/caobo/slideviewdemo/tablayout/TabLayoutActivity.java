package com.caobo.slideviewdemo.tablayout;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.caobo.slideviewdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by cb
 * on 2020-06-12.
 */
public class TabLayoutActivity extends AppCompatActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private TabLayout tabLayout;

    private ViewPager viewPage;

    private String mTitles[] = {
            "西安", "头条推荐", "生活", "娱乐八卦", "体育",
            "段子", "美食", "电影", "科技",};

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        viewPage = findViewById(R.id.viewPage);
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
        tabLayout.setTabIndicatorFullWidth(true);
        // 设置TabLayout和ViewPager绑定
        tabLayout.setupWithViewPager(viewPage, false);
        // 添加TAB标签
        for (String mTitle : mTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitle));
        }
        for (int i = 0; i < mTitles.length ; i++) {
            fragments.add(MyFragment.newInstance(i));
        }

        viewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        // 设置ViewPager默认显示index
        viewPage.setCurrentItem(0);
    }


    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
