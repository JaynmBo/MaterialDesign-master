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

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        toolbar = findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        StatusBarUtils.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
    }

    protected void setToolbarTitle(String toolbarTitle){
        toolbar.setTitle(toolbarTitle);
    }

    protected void setToolBarCallBack() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_vector_test, null));
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
