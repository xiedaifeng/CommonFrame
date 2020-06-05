package com.yidao.module_lib.utils;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with XIAOYUDEXIEE.
 * Date: 2019/8/27
 */
public class CommonUtils {

    public static boolean isPhone(String phone) {
        if (TextUtils.isEmpty(phone)) {
            return false;
        }
        String regex = "^(1[1-9])\\d{9}$";
        if (phone.length() != 11) {
            System.out.println("手机号应为11位数");
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                System.out.println("请填入正确的手机号");
            }
            return isMatch;
        }
    }

    public static void test(String tagsName) {
        String[] split1 = tagsName.split(",");
        System.out.println(split1[0] + "ss");
    }

    public static void main(String[] args) {
//        isPhone("4008308300");
        test("");
    }

    /**
     *  手机号码 前三后四显示 187****2488
     * @param phone
     * @return
     */
    public static String setHidePhone(String phone) {
        System.out.println(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     *  身份证号 前四后四显示 4213****5464
     * @param idCard
     * @return
     */
    public static String setHideIDCardNo(String idCard) {
        System.out.println(idCard.replaceAll("(\\d{4})\\d{10}(\\d{4})", "$1****$2"));
        return idCard.replaceAll("(\\d{4})\\d{10}(\\d{4})", "$1****$2");
    }
}
