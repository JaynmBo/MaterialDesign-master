package com.caobo.slideviewdemo.snackbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.caobo.slideviewdemo.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/**
 * Created by cb
 * on 2020-06-15.
 */
public class SnackBarActivity extends AppCompatActivity {

    private CoordinatorLayout coordinator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        coordinator = findViewById(R.id.coordinator);
    }

    /**
     * 基础使用
     *
     * @param view
     */
    public void onSnackClick(View view) {
        Snackbar.make(view, "提示：您有新消息", Snackbar.LENGTH_SHORT).show();
    }


    /**
     * 设置SnackBar文本颜色和字体颜色
     *
     * @param view
     */
    public void onSnackTextColorClick(View view) {
        Snackbar snackbar = Snackbar.make(view, "提示：您有新消息", Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        if (snackbarView != null) {
            snackbarView.setBackgroundColor(Color.GRAY);
            ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(Color.YELLOW);
        }
        snackbar.show();
    }


    /**
     * 设置Action
     *
     * @param view
     */
    public void onSnackActionClick(View view) {
        Snackbar.make(view, "提示：您有新消息", Snackbar.LENGTH_SHORT)
                //设置Action，右边一个按钮
                .setAction("确定", click -> {
                    Toast.makeText(SnackBarActivity.this, "Open Message", Toast.LENGTH_SHORT).show();
                }).show();
    }

    /**
     * 设置Action字体颜色
     *
     * @param view
     */
    public void onSnackActionTextColorClick(View view) {
        Snackbar.make(view, "提示：您有新消息", Snackbar.LENGTH_SHORT)
                //设置Action，右边一个按钮
                .setAction("确定", click -> {
                })
                //设置Action文本颜色
                .setActionTextColor(Color.YELLOW)
                .show();
    }

    /**
     * 设置Action字体颜色
     *
     * @param view
     */
    public void onSnackAddClick(View view) {
        Snackbar.make(view, "提示：您有新消息", Snackbar.LENGTH_SHORT)
                //设置Action，右边一个按钮
                .setAction("确定", click -> {
                })
                //添加SnackBar监听事件
                .addCallback(new Snackbar.Callback() {

                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        Toast.makeText(SnackBarActivity.this, "onShown", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(SnackBarActivity.this, "onDismissed", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }


    public void onCoordinatorClick(View view) {
        Snackbar.make(coordinator, "提示：您有新消息", Snackbar.LENGTH_SHORT).show();
    }
}
