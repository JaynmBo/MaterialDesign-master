package com.caobo.slideviewdemo.textinputlayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

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

        // 开启错误提示
        userInputLayout.setErrorEnabled(true);
        // 开启计数
        userInputLayout.setCounterEnabled(true);
        // 设置输入最大长度
        userInputLayout.setCounterMaxLength(10);
        // 设置浮动标签字体样式
        userInputLayout.setHintTextAppearance(R.style.hintAppearence);

        userInputLayout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 文本变化前调用
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 文本发生变化时调用
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 文本发生变化后调用
                if(userInputLayout.getEditText().getText().toString().trim().length()>10){
                    userInputLayout.setError("用户名长度超出限制");
                }else{
                    userInputLayout.setError(null);
                }
            }
        });
    }
}
