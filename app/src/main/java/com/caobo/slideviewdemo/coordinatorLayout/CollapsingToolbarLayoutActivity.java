package com.caobo.slideviewdemo.coordinatorLayout;

import android.util.Log;
import android.widget.LinearLayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-30.
 */
public class CollapsingToolbarLayoutActivity extends BaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    private List<String> stringList = new ArrayList<>();

    @BindView(R.id.appBarLayout)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.head_layout)
    LinearLayout head_layout;

    @Override
    protected void initView() {
        for (int i = 1; i <= 100; i++) {
            stringList.add("ITEM " + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerViewAdapter = new RecyclerViewAdapter(R.layout.recyclerview_item, stringList);
        recyclerViewAdapter.bindToRecyclerView(recyclerView);
        Log.e("TAG", "onOffsetChanged: h : " + getResources().getDisplayMetrics().heightPixels);

        appBarLayout.addOnOffsetChangedListener((appBarLayout, i) -> {
            if (i <= -(head_layout.getHeight() - toolbar.getHeight() * 2)) {
                collapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
            } else {
                collapsingToolbarLayout.setTitle("");
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_collapsinglayout;
    }
}