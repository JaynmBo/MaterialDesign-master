package com.caobo.slideviewdemo.cardview;

import android.os.Bundle;
import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.bean.ArticleBean;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

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
    CardImageAdapter cardImageAdapter;


    public static CardImageFragment newInstance() {
        Bundle args = new Bundle();
        CardImageFragment fragment = new CardImageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View rootView) {

        String json = AssetsUtils.getJson("message.json", getActivity());

        List<ArticleBean> articleBeans = new Gson().fromJson(json, new TypeToken<List<ArticleBean>>() {
        }.getType());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardImageAdapter = new CardImageAdapter(R.layout.fragment_tab_image_item, articleBeans);
        cardImageAdapter.bindToRecyclerView(recyclerView);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cardview_behavior_layout;
    }
}