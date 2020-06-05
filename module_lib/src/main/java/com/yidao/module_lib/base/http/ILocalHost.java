package com.yidao.module_lib.base.http;

/**
 * Created by dream on 2017/7/20.
 * 请求地址的配置
 */

public interface ILocalHost {

    String sendVCode = "/p-100"; //发送验证码

    String checkVCode = "/p-101"; //校验验证码

    String register = "/p-102"; //注册

    String login = "/p-103";  //登录

    String findPwd = "/p-104";  //找回密码

    String setFitstPwd = "/s-105"; //首次设置密码

    String myHostUrl = "http://47.111.23.202:6025/apis";
//    String myHostUrl = "http://47.111.23.202:6025/yifei-apidoc/mock?path=/apis";
}
