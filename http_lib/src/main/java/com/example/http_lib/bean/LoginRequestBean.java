package com.example.http_lib.bean;

import com.example.http_lib.annotation.RequestrAnnotation;
import com.example.http_lib.enums.RequestMethodEnum;
import com.yidao.module_lib.base.BaseBean;
import com.yidao.module_lib.base.http.ILocalHost;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/9/18
 */
@RequestrAnnotation(baseUrl = ILocalHost.myHostUrl,path = ILocalHost.login,method = RequestMethodEnum.POST)
public class LoginRequestBean extends BaseBean {

    public Integer loginType;  //登陆方式 1-短信验证码 2-账号密码 3-自动登陆
    public String smsCode;  //短信验证码
    public String password;  //用户密码
    public String machineCode;  //手机机器码
    public String mobile;  //手机号

}
