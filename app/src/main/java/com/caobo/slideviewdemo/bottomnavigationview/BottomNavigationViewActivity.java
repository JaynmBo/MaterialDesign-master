package com.caobo.slideviewdemo.bottomnavigationview;

import android.view.MenuItem;
import android.widget.Toast;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-22.
 */
public class BottomNavigationViewActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.viewPages)
    ViewPager viewPager;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

    private List<Fragment> fragments = new ArrayList<>();

    private int currentTitleIndex = 0;

    @Override
    protected void initView() {


        setToolBarCallBack(toolbar);
        for (int i = 0; i < bottomNavigationView.getMaxItemCount(); i++) {
            fragments.add(NavigationViewFragment.newInstance(i));
        }
        setToolBarTitle(currentTitleIndex);
        // 设置Tab大于3个时的动画
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setItemHorizontalTranslationEnabled(false);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), bottomNavigationView.getMaxItemCount()));
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_item_home:
                        Toast.makeText(BottomNavigationViewActivity.this, "主页", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0, false);
                        break;
                    case R.id.menu_item_project:
                        Toast.makeText(BottomNavigationViewActivity.this, "项目", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.menu_item_movie:
                        Toast.makeText(BottomNavigationViewActivity.this, "电影", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.menu_item_book:
                        Toast.makeText(BottomNavigationViewActivity.this, "干货", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(3, false);
                        break;
                    case R.id.menu_item_personal:
                        Toast.makeText(BottomNavigationViewActivity.this, "个人", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(4, false);
                        break;
                }
                return true;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                setToolBarTitle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setToolBarTitle(int currentTitleIndex) {
        toolbar.setTitle(bottomNavigationView.getMenu().getItem(currentTitleIndex).getTitle());
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
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

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_buttomnav_view;
    }
}