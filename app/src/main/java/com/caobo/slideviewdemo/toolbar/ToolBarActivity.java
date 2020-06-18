package com.caobo.slideviewdemo.toolbar;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class ToolBarActivity extends BaseActivity {

    @BindView(R.id.toolbar)
      Toolbar toolbar;


    @Override
    protected void initView() {
        // 设置ToolBar标题
        toolbar.setTitle("ToolBar");
        // 设置ToolBar副标题
        toolbar.setSubtitle("this is toolbar");
        // 设置navigation button
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24,null));
        // 设置Logo图标
        toolbar.setLogo(getResources().getDrawable(R.drawable.ic_baseline_group_24,null));
        // 设置溢出菜单的图标
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_baseline_more_vert_24,null));
        // 设置Menu
        toolbar.inflateMenu(R.menu.toolbar_menu);

        // 设置Navigation Button监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 设置Menu监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.collect:
                        Toast.makeText(ToolBarActivity.this, "收藏", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.outLogin:
                        Toast.makeText(ToolBarActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.appModel:
                        Toast.makeText(ToolBarActivity.this, "夜间模式", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_toolbar;
    }

    public void caseOnclick(View view) {

        startActivity(new Intent(this, ToolBarDemoActivity.class));
    }
}
