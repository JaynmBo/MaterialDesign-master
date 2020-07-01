package com.caobo.slideviewdemo.coordinatorLayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.cardview.CardBelleAdapter;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardBelleCoordinatorFragment extends Fragment {

    CardBelleAdapter cardBelleAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    public static CardBelleCoordinatorFragment newInstance() {
        Bundle args = new Bundle();
        CardBelleCoordinatorFragment fragment = new CardBelleCoordinatorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String json = AssetsUtils.getJson("belle.json", getActivity());
        List<String> belles = new Gson().fromJson(json, new TypeToken<List<String>>() {
        }.getType());

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        cardBelleAdapter = new CardBelleAdapter(R.layout.fragment_tab_belle_item, belles);
        cardBelleAdapter.bindToRecyclerView(recyclerView);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_cardview_behavior_layout,container,false);
        ButterKnife.bind(this, view);
        return view;
    }

}
