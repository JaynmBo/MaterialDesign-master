package com.caobo.slideviewdemo.cardview;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-19.
 */
public class CardViewActivity extends BaseActivity {
    private List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPage)
    ViewPager viewPage;
    private String mTitles[] = {"TAB 0", "TAB 1", "TAB 2"};

    @Override
    protected void initView() {
        // 设置文本字体颜色[未选中颜色、选中颜色]
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorBlack),
                getResources().getColor(R.color.colorPrimary));
        // 设置下划线跟文本宽度一致
        tabLayout.setTabIndicatorFullWidth(true);
        // 设置TabLayout和ViewPager绑定
        tabLayout.setupWithViewPager(viewPage, false);
        // 添加TAB标签
        for (String mTitle : mTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitle));
        }
        fragments.add(CardImageFragment.newInstance());
        fragments.add(CardTextFragment.newInstance());
        fragments.add(CardBelleFragment.newInstance());

        viewPage.setAdapter(new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        // 设置ViewPager默认显示index
        viewPage.setCurrentItem(0);

    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_tablayout;
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
