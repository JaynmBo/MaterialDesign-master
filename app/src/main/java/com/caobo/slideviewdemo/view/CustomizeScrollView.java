package com.caobo.slideviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class CustomizeScrollView extends HorizontalScrollView {
    public CustomizeScrollView(Context context) {
        this(context, null);
    }

    public CustomizeScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomizeScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




}
