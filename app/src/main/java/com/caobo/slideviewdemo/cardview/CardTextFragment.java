package com.caobo.slideviewdemo.cardview;

import android.os.Bundle;
import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.bean.OfficialBean;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardTextFragment extends LazyFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CardTextAdapter cardTextAdapter;


    public static CardTextFragment newInstance() {

        Bundle args = new Bundle();

        CardTextFragment fragment = new CardTextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {

        String json = AssetsUtils.getJson("official.json", getActivity());

        List<OfficialBean> officialBeans = new Gson().fromJson(json, new TypeToken<List<OfficialBean>>() {
        }.getType());

        cardTextAdapter = new CardTextAdapter(R.layout.fragment_tab_text_item,officialBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardTextAdapter.bindToRecyclerView(recyclerView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cardview_layout;
    }
}
