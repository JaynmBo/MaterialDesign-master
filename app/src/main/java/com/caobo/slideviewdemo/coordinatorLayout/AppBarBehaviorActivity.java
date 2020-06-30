package com.caobo.slideviewdemo.coordinatorLayout;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-30.
 */
public class AppBarBehaviorActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;

    private List<String> stringList = new ArrayList<>();

    @Override
    protected void initView() {
        setToolbarTitle("AppBarLayout Behavior");
        setToolBarCallBack();
        for (int i = 1; i <= 100; i++) {
            stringList.add("ITEM " + i);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerViewAdapter = new RecyclerViewAdapter(R.layout.recyclerview_item, stringList);
        recyclerViewAdapter.bindToRecyclerView(recyclerView);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_appbarbehavior_layout;
    }
}