package com.caobo.slideviewdemo.coordinatorLayout;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.utils.StatusBarUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-30.
 */
public class CollapsingToolbarLayoutActivity extends BaseActivity {
    private List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.topImage)
    ImageView topImage;

    private String mTitles[] = {"动态", "专栏", "沸点", "分享", "更多"};

    @BindView(R.id.userLayout)
    ConstraintLayout userLayout;

    public static final int MAX_ALPHA = 255;

    @Override
    protected void initView() {
        setToolBarCallBack();
        StatusBarUtils.setTransparent(this);
        // 设置TabLayout和ViewPager绑定
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener
                (tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener
                (viewPager));

        for (int i = 0; i < mTitles.length; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTitles[i]));
        }

        fragments.add(CardImageCoordinatorFragment.newInstance());
        fragments.add(CardTextCoordinatorFragment.newInstance());
        fragments.add(CardBelleCoordinatorFragment.newInstance());
        fragments.add(CardTextCoordinatorFragment.newInstance());
        fragments.add(CardBelleCoordinatorFragment.newInstance());

        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (-verticalOffset >= appBarLayout.getTotalScrollRange() / 4) {
                    StatusBarUtils.setColor(CollapsingToolbarLayoutActivity.this, Color.argb(255, 1, 114, 229));
                    toolbar.setBackgroundColor(Color.argb(MAX_ALPHA, 1, 128, 255));
                    userLayout.setVisibility(View.VISIBLE);
                } else {
                    StatusBarUtils.setTransparent(CollapsingToolbarLayoutActivity.this);
                    toolbar.setBackgroundColor(getResources().getColor(R.color.transparent));
                    userLayout.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_collapsinglayout;
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