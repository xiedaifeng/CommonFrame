package com.example.http_lib.utils;


import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.example.http_lib.response.OverseaUserInfoBean;
import com.example.http_lib.response.UserInfoBean;
import com.example.http_lib.response.VersionBean;
import com.yidao.module_lib.utils.SharedPreferencesUtils;

public class UserCacheHelper {

    public static String user_Info = "user_info";
    public static String oversea_user_Info = "oversea_user_info";

    public static String first_open = "first_open";
    public static String version = "version";

    public static UserInfoBean getUserInfo() {
        String userInfo = SharedPreferencesUtils.getString(user_Info, null);
        if (TextUtils.isEmpty(userInfo)) {
            return null;
        }
        return JSON.parseObject(userInfo, UserInfoBean.class);
    }

    public static void saveUserInfo(String userInfo) {
        SharedPreferencesUtils.putString(user_Info, userInfo);
    }

    public static OverseaUserInfoBean getOverseaUserInfo() {
        String userInfo = SharedPreferencesUtils.getString(oversea_user_Info, null);
        if (TextUtils.isEmpty(userInfo)) {
            return null;
        }

        return JSON.parseObject(userInfo, OverseaUserInfoBean.class);
    }

    public static void saveOverseaUserInfo(String userInfo) {
        SharedPreferencesUtils.putString(oversea_user_Info, userInfo);
    }

    public static VersionBean getVersionBean(){
        String versionInfo = SharedPreferencesUtils.getString(version, null);
        if (TextUtils.isEmpty(versionInfo)) {
            return null;
        }
        return JSON.parseObject(versionInfo, VersionBean.class);
    }

    public static void saveVersion(String versionInfo){
        SharedPreferencesUtils.putString(version, versionInfo);
    }

    public static boolean isLogin() {
        UserInfoBean userBean = getUserInfo();
        return userBean != null;
    }

    public static boolean isOverseaLogin() {
        OverseaUserInfoBean userBean = getOverseaUserInfo();
        return userBean != null;
    }

    public static void logOut() {
        SharedPreferencesUtils.remove(user_Info);
        SharedPreferencesUtils.remove(oversea_user_Info);
    }

    public static String getAESToken() {
        OverseaUserInfoBean userInfoBean = getOverseaUserInfo();
        return userInfoBean == null ? "" : userInfoBean.getToken();
    }

    public static boolean isEncrypt() {
        OverseaUserInfoBean userInfoBean = getOverseaUserInfo();
        return userInfoBean != null && userInfoBean.isEnableAuth();
    }

    public static long getUserId() {
        UserInfoBean userInfoBean = getUserInfo();
        return userInfoBean == null ? 0L : userInfoBean.getUserId();
    }

    public static void setFirstOpen(boolean open){
        SharedPreferencesUtils.putBoolean(first_open, open);
    }

    public static boolean getFirstOpen(){
        return SharedPreferencesUtils.getBoolean(first_open, true);
    }
}
