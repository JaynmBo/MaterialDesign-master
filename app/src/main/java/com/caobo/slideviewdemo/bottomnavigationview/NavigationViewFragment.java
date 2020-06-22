package com.caobo.slideviewdemo.bottomnavigationview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;

import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-22.
 */
public class NavigationViewFragment extends LazyFragment {

    @BindView(R.id.navImageView)
    ImageView navImageView;

    private int resIds[] = {R.mipmap.meizi_2, R.mipmap.menu_header_background,
            R.mipmap.pangzi, R.mipmap.scenery_1, R.mipmap.scenery_2};
    int currentIndex;

    public static NavigationViewFragment newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("currentIndex", index);
        NavigationViewFragment fragment = new NavigationViewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    public void onFragmentLoad() {
        currentIndex = getArguments().getInt("currentIndex");
        Log.e("TAG", "onFragmentLoad: currentIndex : " + currentIndex);
        navImageView.setImageResource(resIds[currentIndex]);
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav_view;
    }
}