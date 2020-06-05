package com.yidao.module_lib.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.yidao.module_lib.base.http.ResponseBean;
import com.yidao.module_lib.base.ibase.IBaseEvent;
import com.yidao.module_lib.base.ibase.IBaseEventPlus;
import com.yidao.module_lib.base.ibase.IBasePress;
import com.yidao.module_lib.base.ibase.IBaseView;
import com.yidao.module_lib.manager.ViewManager;
import com.yidao.module_lib.utils.LoggerUtils;
import com.yidao.module_lib.utils.ToastUtil;
import com.yidao.module_lib.widget.LoadingAlertDialog;

import butterknife.ButterKnife;

/**
 * Created by ch_wangjun on 2017/7/10.
 */

public abstract class BaseFragment<T extends IBasePress> extends Fragment implements IBaseView, IBaseEventPlus {

    protected T mBasePress;
    protected LoadingAlertDialog mAlertDialog;

    protected BaseView aty;
    protected Context mct;
    protected View rootView;
    private boolean mViewInflateFinished;

    protected T getPress() {
        return mBasePress;
    }

    protected void setPress(T press) {
        this.mBasePress = press;
    }

    protected abstract int getLayoutId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mct = context;
        aty = (BaseView) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (rootView != null){
            return rootView;
        }
        rootView = inflater.inflate(getLayoutId(), container, false);
//        XFViewInject.inject(this, rootView);
        ButterKnife.bind(this,rootView);
        initPress();
        init();
        mViewInflateFinished = true;
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if ( isVisibleToUser) {
            loadDataStart();
//            mHaveLoadData = true;
        }
    }

    protected void loadDataStart() {

    }


    protected abstract void initPress();

    protected abstract void init();

    @Override
    public void onStart() {
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
//        cancelToast();
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        LoggerUtils.debug("lifeCircle", getClass(), "Fragment onDetach");
        super.onDetach();
    }

    @Override
    public void alertSuccess() {
        dismissLoaddingDialog();
    }

    @Override
    public void alertFailed() {
        dismissLoaddingDialog();
    }

    @Override
    public void skipActivity(Class<? extends IBaseView> view) {
        Intent intent = new Intent(getContext(), view);
        startActivity(intent);
    }

    @Override
    public void skipActivity(Class<? extends IBaseView> view, Bundle bundle) {
        Intent intent = new Intent(getContext(), view);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void skipActivityByFinish(Class<? extends IBaseView> view) {
        skipActivity(view);
//        getActivity().finish();
        ViewManager.getInstance().finishView();
    }

    @Override
    public void skipActivityByFinish(Class<? extends IBaseView> view, Bundle bundle) {
        skipActivity(view, bundle);
//        getActivity().finish();
        ViewManager.getInstance().finishView();
    }


    /**
     * 吐司，由子类调用
     *
     * @param content 吐司的内容/资源id
     */
    @Override
    public void showToast(String content) {
        ToastUtil.showShortToast(content);
    }

    @Override
    public void showToast(int resId) {
        ToastUtil.showShortToast(resId);
    }

    @Override
    public void showLongToast(String content) {
        ToastUtil.showLongToast(content);
    }

    @Override
    public void showLongToast(int resId) {
        ToastUtil.showLongToast(resId);
    }

    @Override
    public void cancelToast() {
        ToastUtil.dismiss();
    }

    @Override
    public void dismissLoaddingDialog() {
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            mAlertDialog.dismiss();
        }
    }

    @Override
    public void showLoaddingDialog() {
        if (mAlertDialog == null) {
            mAlertDialog = new LoadingAlertDialog(aty);
        }
        mAlertDialog.show();
    }

    @Override
    public LoadingAlertDialog getLoadingDialog() {
        return mAlertDialog;
    }

    @Override
    public void setLoaddingMsg(String msg) {
        mAlertDialog.setMessage(msg);
    }


    @Override
    public BaseView getAty() {
        return aty;
    }

    @Override
    public Context getCtx() {
        return mct;
    }

    public void onResponse(boolean success, Class requestCls, ResponseBean responseBean){

    }
}
