package com.example.http_lib.bean;

import com.example.http_lib.annotation.RequestrAnnotation;
import com.example.http_lib.enums.RequestMethodEnum;
import com.yidao.module_lib.base.BaseBean;
import com.yidao.module_lib.base.http.ILocalHost;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/9/18
 */
@RequestrAnnotation(baseUrl = ILocalHost.myHostUrl, path = ILocalHost.getVersion, method = RequestMethodEnum.POST)
public class VersionRequestBean extends BaseBean {

    /**
     * 类型 0-安卓 1-ios
     */
    public Integer type = 0;

    /**
     * 是否最新版本 0-不是 1-是
     */
    public Integer newset;

    public String version;

}
