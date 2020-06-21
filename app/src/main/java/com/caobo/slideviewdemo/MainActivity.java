package com.caobo.slideviewdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.caobo.slideviewdemo.cardview.CardViewActivity;
import com.caobo.slideviewdemo.drawerlayout.DrawerLayoutActivity;
import com.caobo.slideviewdemo.palette.PaletteActivity;
import com.caobo.slideviewdemo.searchview.SearchViewActivity;
import com.caobo.slideviewdemo.snackbar.SnackBarActivity;
import com.caobo.slideviewdemo.tablayout.TabLayoutActivity;
import com.caobo.slideviewdemo.textinputlayout.TextInputLayoutActivity;
import com.caobo.slideviewdemo.toolbar.ToolBarActivity;
import com.caobo.slideviewdemo.utils.StatusBarUtils;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {

        int statusBarHeight = StatusBarUtils.getStatusBarHeight(this);
        Log.e("TAG", "initView: statusBarHeight : "+statusBarHeight );
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

    public void searchViewClick(View view) {
        //判断用户是否已经授权给我们了 如果没有，调用下面方法向用户申请授权，之后系统就会弹出一个权限申请的对话框
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
        } else {
            startActivity(SearchViewActivity.class);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(SearchViewActivity.class);
                } else {
                    Toast.makeText(this, "获取联系人权限失败", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

    public void cardViewClick(View view) {
        startActivity(CardViewActivity.class);
    }

    public void paletteClick(View view) {
        startActivity(PaletteActivity.class);
    }
}
