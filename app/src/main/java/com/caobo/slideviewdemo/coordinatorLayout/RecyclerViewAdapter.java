package com.caobo.slideviewdemo.coordinatorLayout;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.adapter.BaseCompatAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by cb
 * on 2020-06-28.
 */
public class RecyclerViewAdapter extends BaseCompatAdapter<String, BaseViewHolder> {


    public RecyclerViewAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.textView, item);
    }
}