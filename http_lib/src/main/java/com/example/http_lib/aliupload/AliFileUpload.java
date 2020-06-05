package com.example.http_lib.aliupload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.yidao.module_lib.utils.LogUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/10/8
 */
public class AliFileUpload {

    private static String bucketName = "efei";
    private static String url = "https://"+bucketName+".oss-cn-beijing.aliyuncs.com";
    public static PutObjectResult fileUpload( File file){

      /*  String usderid = SharedPreferencesUtils.getString("USDERID", "");
        String name = file.getName();
        String[] split = name.split("\\.");
        String fileName = usderid+split[1];*/
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
        qualityCompress(bitmap,file);
// 构造上传请求。
        PutObjectRequest put = new PutObjectRequest(bucketName, "picture/"+file.getName(), file.getPath());

// 文件元信息的设置是可选的。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setContentType("application/octet-stream"); // 设置content-type。
// metadata.setContentMD5(BinaryUtil.calculateBase64Md5(uploadFilePath)); // 校验MD5。
// put.setMetadata(metadata);

        try {
            PutObjectResult putResult = AliuploadInit.getInstance().getOssClient().putObject(put);
//            String imgUrl = "https://laiyipiao.oss-cn-hangzhou.aliyuncs.com/picture/"+file.getName();
            String imgUrl = url+"/picture/"+file.getName();
            putResult.setServerCallbackReturnBody(imgUrl);
            Log.d("img_ali",imgUrl);
            Log.d("PutObject", "UploadSuccess");
            Log.d("ETag", putResult.getETag());
            Log.d("RequestId", putResult.getRequestId());
            return putResult;
        } catch (ClientException e) {
            // 本地异常，如网络异常等。
            e.printStackTrace();
        } catch (ServiceException e) {
            // 服务异常。
            Log.e("RequestId", e.getRequestId());
            Log.e("ErrorCode", e.getErrorCode());
            Log.e("HostId", e.getHostId());
            Log.e("RawMessage", e.getRawMessage());
        }
        return null;
    }

    /**
     * 文件上传
     *
     *
     * @param fileName
     *            文件名称
     * @param postfix
     *            文件后缀名
     * @param filePath
     *            文件路径
     * @return 文件最终存放的绝对路径
     */
    public static String OSSUpload(String localPath, String fileName, String postfix, String filePath) {
      /*  if (this.accessKeyId == null || this.accessKeySecret == null || this.bucketName == null
                || this.endPoint == null) {
            throw new RuntimeException("OSS param missing");
        }*/
        // 最终文件全路径
        String finalPath = filePath + fileName ;
        OSSClient client = AliuploadInit.getInstance().getOssClient();
        // 创建上传Object的Metadata
        ObjectMetadata metadata = new ObjectMetadata();
        int size = 0;
        metadata.setContentLength(size);
        LogUtils.d("oss文件上传,文件大小:" + size + ",文件名:" + fileName + ",文件存放路径:" + filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(localPath);
            size = fileInputStream.available();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        metadata.setCacheControl("no-cache");
        metadata.setHeader("Pragma", "no-cache");
        // 设置文件网络类型
        // metadata.setContentType(fileType);
//        metadata.setContentDisposition("filename/filesize=" + fileName.substring(0,fileName.length()-4) + "/" + size + "Byte.");
        try {
            PutObjectRequest put = new PutObjectRequest(bucketName,finalPath, localPath);
            LogUtils.d( "oss文件上传开始");
            PutObjectResult putObjectResult = client.putObject(put);
            LogUtils.d( "oss文件上传完成,路径为:" + finalPath);
            String imgUrl = url+"/picture/"+fileName;
            putObjectResult.setServerCallbackReturnBody(imgUrl);
            return imgUrl;
        } catch (Exception e) {
            LogUtils.d("oss文件上传失败:" + e.getMessage());
        }
        return finalPath;
    }

    /**
     * 尺寸压缩（通过缩放图片像素来减少图片占用内存大小）
     *
     * @param bmp
     * @param file
     */

    public static void sizeCompress(Bitmap bmp, File file) {
        // 尺寸压缩倍数,值越大，图片尺寸越小
        int ratio = 8;
        // 压缩Bitmap到对应尺寸
        Bitmap result = Bitmap.createBitmap(bmp.getWidth() / ratio, bmp.getHeight() / ratio, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, bmp.getWidth() / ratio, bmp.getHeight() / ratio);
        canvas.drawBitmap(bmp, null, rect, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        result.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 质量压缩
     * 设置bitmap options属性，降低图片的质量，像素不会减少
     * 第一个参数为需要压缩的bitmap图片对象，第二个参数为压缩后图片保存的位置
     * 设置options 属性0-100，来实现压缩（因为png是无损压缩，所以该属性对png是无效的）
     *
     * @param bmp
     * @param file
     */
    public static void qualityCompress(Bitmap bmp, File file) {
        // 0-100 100为不压缩
        int quality = 100;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把压缩后的数据存放到baos中
        bmp.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
