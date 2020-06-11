package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.yidao.module_lib.base.BaseView;
import com.yidao.module_lib.utils.CommonGlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseView {

    @BindView(R.id.btn_click)
    Button btnClick;
    @BindView(R.id.iv_cover)
    ImageView ivCover;

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

        CommonGlideUtils.showImageView(getCtx(),"https://cdn.pixabay.com/photo/2020/05/17/09/10/mountain-spring-5180660_960_720.jpg",ivCover);


    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        Log.e("error", "click");
    }

}
