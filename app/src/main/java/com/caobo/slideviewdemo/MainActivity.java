package com.caobo.slideviewdemo;

import android.view.View;

import com.caobo.slideviewdemo.drawerlayout.DrawerLayoutActivity;
import com.caobo.slideviewdemo.snackbar.SnackBarActivity;
import com.caobo.slideviewdemo.tablayout.TabLayoutActivity;
import com.caobo.slideviewdemo.textinputlayout.TextInputLayoutActivity;
import com.caobo.slideviewdemo.toolbar.ToolBarActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    public void toolbarClick(View view) {
        startActivity(ToolBarActivity.class);
    }

    public void snackBarClick(View view) {
        startActivity(SnackBarActivity.class);
    }

    public void tabLayoutClick(View view) {
        startActivity(TabLayoutActivity.class);
    }

    public void textInputLayoutClick(View view) {
        startActivity(TextInputLayoutActivity.class);
    }

    public void drawerLayoutClick(View view) {
        startActivity(DrawerLayoutActivity.class);
    }

    public void coordinatorClick(View view) {
        startActivity(ToolBarActivity.class);
    }
}
