package com.caobo.slideviewdemo.searchview;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;
import com.google.android.material.snackbar.Snackbar;

import java.lang.reflect.Method;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/17 0017
 * Describe:
 **/
public class SearchViewActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.listView)
    ListView listView;
    SearchView mSearchView;
    SearchView.SearchAutoComplete mSearchEditView;
    LinearLayout search_plate;
    LinearLayout submit_area;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mSearchEditView.isShown()) {
                        Method method = mSearchView.getClass().getDeclaredMethod("onCloseClicked");
                        method.setAccessible(true);
                        method.invoke(mSearchView);
                    } else {
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_searchview;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchview_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(item);

//        //设置搜索框直接展开显示。左侧有放大镜(在搜索框中) 右侧有叉叉 可以关闭搜索框
//        mSearchView.setIconified(false);
//        //设置搜索框直接展开显示。左侧有放大镜(在搜索框外) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
//        mSearchView.setIconifiedByDefault(false);
//        //设置搜索框直接展开显示。左侧有无放大镜(在搜索框中) 右侧无叉叉 有输入内容后有叉叉 不能关闭搜索框
//        mSearchView.onActionViewExpanded();
//        // 设置提交按钮是否可见
//        mSearchView.setSubmitButtonEnabled(true);
        // 获取提交按钮ID
        ImageView mSearchGoBtn = mSearchView.findViewById(R.id.search_go_btn);
        // 设置提交按钮图标
        mSearchGoBtn.setImageResource(R.drawable.ic_baseline_emoji_emotions_24);
        // 搜索框View
        mSearchEditView = mSearchView.findViewById(R.id.search_src_text);
        // 等同于 mSearchView.setQueryHint("请输入搜索内容")
        mSearchEditView.setHint("请输入搜索内容");
        mSearchEditView.setHintTextColor(getResources().getColor(R.color.selectable_item_background_general_light_accent));
        mSearchEditView.setTextColor(getResources().getColor(R.color.text_color_dark));
        mSearchEditView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
//        // 设置搜索框背景样式
        mSearchEditView.setBackground(getDrawable(R.drawable.shape_toolbar));
//        // 去掉搜索框默认的下划线
        search_plate = mSearchView.findViewById(R.id.search_plate);
        submit_area = mSearchView.findViewById(R.id.submit_area);
        search_plate.setBackground(null);
        submit_area.setBackground(null);


        // 关闭监听
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                listView.setAdapter(null);
                Toast.makeText(SearchViewActivity.this, "close", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchViewActivity.this, "open", Toast.LENGTH_SHORT).show();
            }
        });
        // 监听文本变化
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // 提交文本时调用
                Snackbar.make(mSearchGoBtn, query, Snackbar.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // 文本搜索框发生变化时调用
//                if(TextUtils.isEmpty(newText)){
//                    listView.setVisibility(View.GONE);
//                }else {
//                    listView.setVisibility(View.VISIBLE);
//                    setAdapter();
//                }
                setAdapter();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);

    }

    private void setAdapter() {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
//        if (listView.getAdapter() != null) {
//            ((SimpleCursorAdapter) listView.getAdapter()).changeCursor(cursor);
//        } else {
//            SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(SearchViewActivity.this,
//                    R.layout.searchview_item, cursor,
//                    new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
//                    new int[]{R.id.name});
//            listView.setAdapter(simpleAdapter);
//        }
        SimpleCursorAdapter simpleAdapter = new SimpleCursorAdapter(SearchViewActivity.this,
                R.layout.searchview_item, cursor,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME},
                new int[]{R.id.name});
        // 设置SearchView 适配器
        mSearchView.setSuggestionsAdapter(simpleAdapter);
        //设置触发查询的最少字符数（默认2个字符才会触发查询）
        mSearchEditView.setThreshold(1);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.setting) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
