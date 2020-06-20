package com.caobo.slideviewdemo.cardview;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.adapter.BaseCompatAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardBelleAdapter extends BaseCompatAdapter<String, BaseViewHolder> {

    public CardBelleAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    public CardBelleAdapter(List<String> data) {
        super(data);
    }

    public CardBelleAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(mContext).load(item).placeholder(R.mipmap.img_default_meizi).into((ImageView) helper.getView(R.id.belleImage));
    }
}
