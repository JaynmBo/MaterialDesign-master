package com.caobo.slideviewdemo.toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/17 0017
 * Describe:
 **/
public class SearchViewActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void initView() {
        toolbar.inflateMenu(R.menu.searchview_menu);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_searchview;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchview_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(item);
        // 设置一出来就直接呈现SearchView搜索框
        mSearchView.setIconified(false);
        // 设置一出来就直接呈现SearchView搜索框，并且不可隐藏
        mSearchView.setIconifiedByDefault(false);
        // 设置提交按钮是否可见(默认是个小三角形)
        mSearchView.setSubmitButtonEnabled(true);

        mSearchView.findViewById(R.id.appModel);

        // 关闭监听
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 监听文本变化
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 提交文本时调用
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 文本搜索框发生变化时调用
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.setting) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
