package com.example.http_lib.bean;

import com.example.http_lib.annotation.RequestrAnnotation;
import com.example.http_lib.enums.RequestMethodEnum;
import com.yidao.module_lib.base.BaseBean;
import com.yidao.module_lib.base.http.ILocalHost;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/9/18
 */
@RequestrAnnotation(baseUrl = ILocalHost.myHostUrl,path = ILocalHost.findPwd,method = RequestMethodEnum.POST)
public class FindPwdRequestBean extends BaseBean {


    public String machineCode; //手机机器码
    public String smsCode;//短信验证码
    public String phone;//手机号
    public String password;//用户密码，至少6位(需要一次md5加密)



}
