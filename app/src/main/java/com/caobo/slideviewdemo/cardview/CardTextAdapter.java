package com.caobo.slideviewdemo.cardview;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.adapter.BaseCompatAdapter;
import com.caobo.slideviewdemo.bean.OfficialBean;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Administrator on 2020/6/20 0020
 * Describe:
 **/
public class CardTextAdapter extends BaseCompatAdapter<OfficialBean, BaseViewHolder> {

    public CardTextAdapter(int layoutResId, List<OfficialBean> data) {
        super(layoutResId, data);
    }

    public CardTextAdapter(List<OfficialBean> data) {
        super(data);
    }

    public CardTextAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, OfficialBean item) {
        helper.setText(R.id.tv_name, item.getAuthor())
                .setText(R.id.tv_time, item.getNiceShareDate())
                .setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_label, item.getSuperChapterName() + "·" + item.getAuthor());
    }
}
