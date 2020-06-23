package com.caobo.slideviewdemo.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.adapter.BaseCompatAdapter;
import com.caobo.slideviewdemo.bean.ArticleBean;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;

/**
 * Created by cb
 * on 2020-06-19.
 */
public class PaletteImageAdapter extends BaseCompatAdapter<ArticleBean, BaseViewHolder> {

    public PaletteImageAdapter(int layoutResId, List<ArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleBean item) {

        FutureTarget<Bitmap> bitmap = Glide.with(mContext)
                .asBitmap()
                .load(item.getImageUrl())
                .submit();
        new Thread(() -> {
            try {
                setPalette(bitmap.get(), helper, item);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void setPalette(Bitmap bitmap, BaseViewHolder helper, ArticleBean item) {
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                //获取某种特性颜色的样品
                Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();
                if (lightVibrantSwatch == null) {
                    for (Palette.Swatch swatch : palette.getSwatches()) {
                        lightVibrantSwatch = swatch;
                        break;
                    }
                }
                //谷歌推荐的：图片的整体的颜色rgb的混合值---主色调
                int rgb = lightVibrantSwatch.getRgb();
                //谷歌推荐：图片中间的文字颜色
                int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
                //谷歌推荐：作为标题的颜色（有一定的和图片的对比度的颜色值）
                int titleTextColor = lightVibrantSwatch.getTitleTextColor();

                helper.setText(R.id.articleListTitle, item.getTitle())
                        .setTextColor(R.id.articleListTitle, titleTextColor)
                        .setBackgroundColor(R.id.articleListTitle, getTranslucentColor(0.8f, rgb));
                ((ImageView) helper.getView(R.id.articleListImg)).setImageBitmap(bitmap);
            }
        });
    }

    /**
     * @param percent 透明度
     * @param rgb     RGB值
     * @return
     */
    protected int getTranslucentColor(float percent, int rgb) {
        int blue = Color.blue(rgb);
        int green = Color.green(rgb);
        int red = Color.red(rgb);
        int alpha = Color.alpha(rgb);
        alpha = Math.round(alpha * percent);
        return Color.argb(alpha, red, green, blue);
    }
}