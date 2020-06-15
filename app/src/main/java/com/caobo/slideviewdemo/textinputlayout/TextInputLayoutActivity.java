package com.caobo.slideviewdemo.textinputlayout;

import android.os.Bundle;

import com.caobo.slideviewdemo.R;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by cb
 * on 2020-06-15.
 */
public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout userInputLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputlayout);

        userInputLayout = findViewById(R.id.userInputLayout);


        // 是否获取焦点的时候，hint文本上移到左上角开启动画，默认True开启状态
        userInputLayout.setHintAnimationEnabled(false);

        // 开启错误提示
        userInputLayout.setErrorEnabled(true);
        // 开启计数
        userInputLayout.setCounterEnabled(true);
        // 设置输入最大长度
        userInputLayout.setCounterMaxLength(10);

        // 是否开启浮动标签
        userInputLayout.setHintEnabled(true);

        // 设置浮动标签字体样式
        userInputLayout.setHintTextAppearance(R.style.hintAppearence);

        // 设置


    }
}
