package com.caobo.slideviewdemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import com.caobo.slideviewdemo.utils.StatusBarUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2020/6/16 0016
 * Describe:
 **/
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        ButterKnife.bind(this);
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
    }

    protected void setToolBarCallBack(Toolbar toolbar) {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24, null));
        // 设置Navigation Button监听
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected abstract void initView();

    protected abstract int getLayoutResID();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }


    public void startActivity(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }
}
