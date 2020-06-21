package com.caobo.slideviewdemo.palette;

import android.graphics.Color;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/21 0021
 * Describe:
 **/
public class PaletteActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.viewPage)
    ViewPager viewPager;

    String tabs[] = {"TAB 1", "TAB 2", "TAB 3"};

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void initView() {
        setToolBarCallBack(toolbar);
        tabLayout.setTabTextColors(Color.GRAY, Color.BLACK);
        for (String tab : tabs) {
            tabLayout.addTab(tabLayout.newTab().setText(tab));
        }

        fragments.add(new PaletteDemoFragment());
        fragments.add(new PaletteImageFragment());
        fragments.add(new PaletteBelleFragment());

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()) {

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabs[position];
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
        });
    }


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_palette;
    }
}
