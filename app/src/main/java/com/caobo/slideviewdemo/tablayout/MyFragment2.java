package com.caobo.slideviewdemo.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.caobo.slideviewdemo.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2020/6/14 0014
 * Describe:
 **/
public class MyFragment2 extends Fragment {

    private View rootView;

    private TextView textView;

    public static MyFragment2 newInstance(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        MyFragment2 fragment = new MyFragment2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_tablayout, container, false);
        }
        ButterKnife.bind(this, rootView);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        tabIndex = getArguments().getInt("position");
        textView = rootView.findViewById(R.id.textView);
    }

    private int tabIndex;



}
