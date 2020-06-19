package com.caobo.slideviewdemo.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.LayoutRes;

/**
 * Created by Horrarndoo on 2017/9/20.
 * <p>
 */

public abstract class BaseCompatAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T,
        K> {

    public BaseCompatAdapter(@LayoutRes int layoutResId,   List<T> data) {
        super(layoutResId, data);
        init();
    }

    public BaseCompatAdapter(  List<T> data) {
        super(data);
        init();
    }

    public BaseCompatAdapter(@LayoutRes int layoutResId) {
        super(layoutResId);
        init();
    }

    private void init(){
        openLoadAnimation();//开启默认动画载入（仅开启加载新item时开启动画）
    }
}
