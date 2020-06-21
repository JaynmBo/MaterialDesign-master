package com.caobo.slideviewdemo.palette;

import android.view.View;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;
import com.caobo.slideviewdemo.utils.AssetsUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/21 0021
 * Describe:
 **/
public class PaletteBelleFragment extends LazyFragment {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    PaletteBelleAdapter belleAdapter;

    @Override
    protected void initView(View rootView) {
        String json = AssetsUtils.getJson("belle.json", getActivity());
        List<String> belles = new Gson().fromJson(json, new TypeToken<List<String>>() {
        }.getType());
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        belleAdapter = new PaletteBelleAdapter(R.layout.fragment_palette_belle_item, belles);
        belleAdapter.bindToRecyclerView(recyclerView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_palette;
    }
}
