package com.example.http_lib.aliupload;

import android.content.Context;

import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/10/8
 */
public class AliuploadInit {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "https://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
     String accessKeyId = "LTAI4FxVsGN1aswuD3Dt9fx2";
     String accessKeySecret = "hBcnCoWtC4eKBPp5oLwZzK415x0QcT";
     OSSClient ossClient;
    static AliuploadInit aliuploadInit;

    public static AliuploadInit getInstance() {
        if (aliuploadInit == null) {
            synchronized (AliuploadInit.class) {
                if (aliuploadInit == null)
                    aliuploadInit = new AliuploadInit();
            }
        }
        return aliuploadInit;
    }


    public  void initOSS(Context context) {
        if (ossClient == null) {
            OSSPlainTextAKSKCredentialProvider ossPlainTextAKSKCredentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
            ossClient = new OSSClient(context, endpoint, ossPlainTextAKSKCredentialProvider);
        }
    }

    public OSSClient getOssClient() {
        return ossClient;
    }

    public void setOssClient(OSSClient ossClient) {
        this.ossClient = ossClient;
    }
}
