package com.caobo.slideviewdemo.coordinatorLayout;

import android.view.View;
import android.widget.Toast;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-29.
 */
public class SnackBarBehaviorActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;

    private List<String> stringList = new ArrayList<>();

    private boolean snackBarVisible = false;

    @Override
    protected void initView() {
        setToolbarTitle("SnackBar Behavior");
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
        return R.layout.activity_fabbehavior_layout;
    }

    public void fabClick(View view) {
        if(snackBarVisible){
           return;
        }
        Snackbar snackbar = Snackbar.make(view, "谁让你点击的？", Snackbar.LENGTH_SHORT);
        if (!snackbar.isShown()) {
            Snackbar.make(view, "谁让你点击的？", Snackbar.LENGTH_SHORT)
                    .setAction("关闭", v -> {
                        Toast.makeText(SnackBarBehaviorActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                    }).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);
                    snackBarVisible = false;
                }

                @Override
                public void onShown(Snackbar transientBottomBar) {
                    super.onShown(transientBottomBar);
                    snackBarVisible = true;
                }
            }).show();
        }
    }
}