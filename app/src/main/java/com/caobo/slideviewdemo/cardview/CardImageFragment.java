package com.caobo.slideviewdemo.cardview;

import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-19.
 */
public class CardImageFragment extends LazyFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;



    @Override
    protected void initView(View rootView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cardview_layout;
    }
}