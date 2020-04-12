package com.bsuc.homestay.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author： yyhuang
 * Date：2020/4/6 0006
 */
public class ToolUtil {
    //判断当前请求是否为Ajax
    public static boolean isAjax(HttpServletRequest request) {
        String accept = request.getHeader("accept");
        return accept != null && accept.contains("application/json") || "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;

    }

    /**
     * 获取未来 第 past 天的日期
     *
     * @param past
     * @return
     */
    public static String getFetureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     *  EDS的加密解密代码
     */
    private static final byte[] DES_KEY = { 21, 1, -110, 82, -32, -85, -128, -65 };

    //加密   String s1 = encryptBasedDes(password);
    public static String encryptBasedDes(String data) {
        String encryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            // log.error("加密错误，错误信息：", e);
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }

    //解密  decryptBasedDes(user.getPassword())
    public static String decryptBasedDes(String cryptData) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串进行解码，解码为为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }
}