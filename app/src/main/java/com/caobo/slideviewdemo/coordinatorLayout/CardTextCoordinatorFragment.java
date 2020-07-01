package com.caobo.slideviewdemo.coordinatorLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.bean.OfficialBean;
import com.caobo.slideviewdemo.cardview.CardTextAdapter;
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
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardTextCoordinatorFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CardTextAdapter cardTextAdapter;


    public static CardTextCoordinatorFragment newInstance() {
        Bundle args = new Bundle();
        CardTextCoordinatorFragment fragment = new CardTextCoordinatorFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String json = AssetsUtils.getJson("official.json", getActivity());

        List<OfficialBean> officialBeans = new Gson().fromJson(json, new TypeToken<List<OfficialBean>>() {
        }.getType());

        cardTextAdapter = new CardTextAdapter(R.layout.fragment_tab_text_item, officialBeans);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardTextAdapter.bindToRecyclerView(recyclerView);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cardview_behavior_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
