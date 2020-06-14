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


    private String mTitles[] = {
            "西安", "头条推荐", "生活", "娱乐八卦", "体育",
            "段子", "美食", "电影", "科技",};

    private int tabIndex;

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
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tablayout;
    }


    @Override
    public void onFragmentLoad() {
        super.onFragmentLoad();
        tabIndex = getArguments().getInt("position");
        Log.e("TAG", "onFragmentLoad: 加载 : " + mTitles[tabIndex]);
        textView.setText(mTitles[tabIndex]);
    }

    @Override
    public void onFragmentLoadStop() {
        super.onFragmentLoadStop();

        tabIndex = getArguments().getInt("position");
        // 暂停一切操作
        Log.e("TAG", "onFragmentLoadStop: 停止加载 : " + mTitles[tabIndex]);
    }
}
