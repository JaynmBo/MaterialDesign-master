package com.caobo.slideviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * Created by cb
 * on 2020-06-10.
 */
public class CustomizeView extends HorizontalScrollView {
    public CustomizeView(Context context) {
        this(context, null);
    }

    public CustomizeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomizeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
