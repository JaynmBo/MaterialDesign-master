package com.caobo.slideviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.caobo.slideviewdemo.toolbar.ToolBarActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private int a = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toolbarClick(View view) {
        startActivity(new Intent(this, ToolBarActivity.class));
    }
}
