package com.caobo.slideviewdemo.toolbar;


import com.caobo.slideviewdemo.BaseActivity;
import com.caobo.slideviewdemo.R;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class ToolBarDemoActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void initView() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24, null));
        toolbar.inflateMenu(R.menu.toolbar_case_menu);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_toolbar_case;
    }
}
