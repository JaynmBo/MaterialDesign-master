package com.caobo.slideviewdemo.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.caobo.slideviewdemo.R;
import com.caobo.slideviewdemo.tablayout.LazyFragment;

import androidx.annotation.Nullable;
import androidx.palette.graphics.Palette;
import butterknife.BindView;

/**
 * Created by Administrator on 2020/6/21 0021
 * Describe:
 **/
public class PaletteDemoFragment extends LazyFragment {

    @BindView(R.id.iv)
    ImageView imageView;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tv5)
    TextView tv5;
    @BindView(R.id.tv6)
    TextView tv6;

    @Override
    protected void initView(View rootView) {
        /**
         // 获取到柔和的深色的颜色（可传默认值）
         palette.getDarkMutedColor(Color.BLUE);
         // 获取到活跃的深色的颜色（可传默认值）
         palette.getDarkVibrantColor(Color.BLUE);
         // 获取到柔和的明亮的颜色（可传默认值）
         palette.getLightMutedColor(Color.BLUE);
         // 获取到活跃的明亮的颜色（可传默认值）
         palette.getLightVibrantColor(Color.BLUE);
         // 获取图片中最活跃的颜色（也可以说整个图片出现最多的颜色）（可传默认值）
         palette.getVibrantColor(Color.BLUE);
         // 获取图片中一个最柔和的颜色（可传默认值）
         palette.getMutedColor(Color.BLUE);
         // ...  这里省略其他的方法。
         */
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                //获取到柔和的深色的颜色（可传默认值）
                int darkMutedColor = palette.getDarkMutedColor(Color.BLUE);//如果分析不出来，则返回默认颜色
                //获取到柔和的明亮的颜色（可传默认值）
                int lightMutedColor = palette.getLightMutedColor(Color.BLUE);
                //获取到活跃的深色的颜色（可传默认值）
                int darkVibrantColor = palette.getDarkVibrantColor(Color.BLUE);
                //获取到活跃的明亮的颜色（可传默认值）
                int lightVibrantColor = palette.getLightVibrantColor(Color.BLUE);
                //获取图片中一个最柔和的颜色（可传默认值）
                int mutedColor = palette.getMutedColor(Color.BLUE);
                //获取图片中最活跃的颜色（也可以说整个图片出现最多的颜色）（可传默认值）
                int vibrantColor = palette.getVibrantColor(Color.BLUE);
                //获取某种特性颜色的样品
                Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();
                //谷歌推荐的：图片的整体的颜色rgb的混合值---主色调
                int rgb = lightVibrantSwatch.getRgb();
                //谷歌推荐：图片中间的文字颜色
                int bodyTextColor = lightVibrantSwatch.getBodyTextColor();
                //谷歌推荐：作为标题的颜色（有一定的和图片的对比度的颜色值）
                int titleTextColor = lightVibrantSwatch.getTitleTextColor();
                //颜色向量
                float[] hsl = lightVibrantSwatch.getHsl();
                //分析该颜色在图片中所占的像素多少值
                int population = lightVibrantSwatch.getPopulation();

                tv1.setText("darkMutedColor");
                tv1.setBackgroundColor(darkMutedColor);
                tv2.setText("lightMutedColor");
                tv2.setBackgroundColor(lightMutedColor);
                tv3.setText("darkVibrantColor");
                tv3.setBackgroundColor(darkVibrantColor);
                tv4.setText("lightVibrantColor");
                tv4.setBackgroundColor(lightVibrantColor);
                tv5.setText("mutedColor");
                tv5.setBackgroundColor(mutedColor);
                tv6.setText("vibrantColor");
                tv6.setBackgroundColor(vibrantColor);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_palette_demo;
    }
}
