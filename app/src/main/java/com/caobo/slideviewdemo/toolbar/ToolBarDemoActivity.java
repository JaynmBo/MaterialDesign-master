package com.caobo.slideviewdemo.toolbar;


import android.os.Bundle;

import com.caobo.slideviewdemo.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class ToolBarDemoActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_case);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24, null));
        toolbar.inflateMenu(R.menu.toolbar_case_menu);
    }
}
