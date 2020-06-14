package com.caobo.slideviewdemo.tablayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * Created by cb
 * on 2020-06-12.
 */
abstract class LazyFragment extends Fragment {
    public View rootView;

    public Activity mContext;
    /**
     * 是否初始化过布局
     */
    private boolean isViewCreated = false;

    /**
     * 当前显示状态
     */
    private boolean currentVisibleState = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        ButterKnife.bind(this, rootView);
        mContext = getActivity();

        initView(rootView);
        isViewCreated = true;

        // 第一次加载时，分发加载数据方法
        if (getUserVisibleHint()) {
            disPatchUserVisibleHint(true);
        }
        return rootView;
    }

    protected abstract void initView(View rootView);


    /**
     * 判断Fragment是否可见
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        // 当View已经加载完毕
        if (isViewCreated) {
            // 从不可见到可见
            if (isVisibleToUser == true && !currentVisibleState) {
                disPatchUserVisibleHint(true);
            } else if (isVisibleToUser == false && currentVisibleState) {
                disPatchUserVisibleHint(false);
            }

//            disPatchUserVisibleHint(isVisibleToUser);

        }
    }

    @Override
    public void onPause() {
        super.onPause();
//        if(currentVisibleState&&getUserVisibleHint()){
//            disPatchUserVisibleHint(false);
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        if (!currentVisibleState && getUserVisibleHint()) {
//            disPatchUserVisibleHint(true);
//        }
    }

    private void disPatchUserVisibleHint(boolean isVisible) {
        // 解决跨页面跳转重复加载数据问题，如果当前加载状态=isVisible时，不再重复分发
        if (currentVisibleState == isVisible) {
            return;
        }
        currentVisibleState = isVisible;
        if (isVisible) {
            onFragmentLoad();
        } else {
            onFragmentLoadStop();
        }
    }

    public void onFragmentLoadStop() {}

    public void onFragmentLoad() {}

    /**
     * 获取布局ID
     *
     * @return
     */
    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        super.onDestroy();
        this.rootView = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.bind(getActivity()).unbind();
//        isViewCreated =false;
//        currentVisibleState =false;
    }


    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }


    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}
