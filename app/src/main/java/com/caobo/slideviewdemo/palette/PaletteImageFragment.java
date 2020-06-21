package com.caobo.slideviewdemo.palette;

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
 * Created by Administrator on 2020/6/21 0021
 * Describe:
 **/
public class PaletteImageFragment extends LazyFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    PaletteImageAdapter cardImageAdapter;

    @Override
    protected void initView(View rootView) {
        String json = AssetsUtils.getJson("message.json", getActivity());

        List<ArticleBean> articleBeans = new Gson().fromJson(json, new TypeToken<List<ArticleBean>>() {
        }.getType());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardImageAdapter = new PaletteImageAdapter(R.layout.fragment_palette_image_item, articleBeans);
        cardImageAdapter.bindToRecyclerView(recyclerView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_palette;
    }
}
