package com.caobo.slideviewdemo.cardview;

import android.os.Bundle;
import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardBelleFragment extends LazyFragment {

    CardBelleAdapter cardBelleAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static CardBelleFragment newInstance() {
        Bundle args = new Bundle();
        CardBelleFragment fragment = new CardBelleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {

        String json = AssetsUtils.getJson("belle.json", getActivity());
        List<String> belles = new Gson().fromJson(json, new TypeToken<List<String>>() {
        }.getType());

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        cardBelleAdapter = new CardBelleAdapter(R.layout.fragment_tab_belle_item, belles);
        cardBelleAdapter.bindToRecyclerView(recyclerView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cardimage_layout;
    }
}
