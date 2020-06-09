package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.yidao.module_lib.base.BaseView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseView {

    @BindView(R.id.btn_click)
    Button btnClick;

    @Override
    protected int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {

    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        Log.e("error","click");
    }
}
