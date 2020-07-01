package com.caobo.slideviewdemo.coordinatorLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.bean.ArticleBean;
import com.caobo.slideviewdemo.cardview.CardImageAdapter;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cb
 * on 2020-06-19.
 */
public class CardImageCoordinatorFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CardImageAdapter cardImageAdapter;


    public static CardImageCoordinatorFragment newInstance() {
        Bundle args = new Bundle();
        CardImageCoordinatorFragment fragment = new CardImageCoordinatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cardview_behavior_layout,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String json = AssetsUtils.getJson("message.json", getActivity());

        List<ArticleBean> articleBeans = new Gson().fromJson(json, new TypeToken<List<ArticleBean>>() {
        }.getType());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardImageAdapter = new CardImageAdapter(R.layout.fragment_tab_image_item, articleBeans);
        cardImageAdapter.bindToRecyclerView(recyclerView);
    }
}