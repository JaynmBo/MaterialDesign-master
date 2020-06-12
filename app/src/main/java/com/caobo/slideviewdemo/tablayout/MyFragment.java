package com.caobo.slideviewdemo.tablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.caobo.slideviewdemo.R;

/**
 * Created by cb
 * on 2020-06-12.
 */
public class MyFragment extends LazyFragment {

    private TextView textView;

    public static MyFragment newInstance(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {
        tabIndex = getArguments().getInt("position");
        textView = rootView.findViewById(R.id.textView);

        textView.setText(tabIndex + "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tablayout;
    }

    private int tabIndex;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        tabIndex = getArguments().getInt("position");
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
    }


    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();

        tabIndex = getArguments().getInt("position");
        // 暂停一切操作
        Log.e("TAG", "onFragmentLoadStop: tabIndex : " + tabIndex);
    }
}
