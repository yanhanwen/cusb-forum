package com.forum.util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

    static Logger logger = LoggerFactory.getLogger(StringUtil.class);


    /**
     * 将字节数组转换成字符串
     *
     * @param data 字节数组
     * @return 字符串
     */
    public static String toHexString(byte[] data) {
        StringBuilder output = new StringBuilder();
        for (int n = 0; data != null && n < data.length; n++) {
            String tmp = Integer.toHexString(data[n] & 0XFF);
            if (tmp.length() == 1) {
                output.append('0');
            }

            output.append(tmp);
        }
        return output.toString().toLowerCase();
    }



    /**
     * 将String数组连接为一个分隔符分隔的字符串
     */
    public static String joinString(String[] data, String seperator) {
        if (null == data || data.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            if (i != 0) {
                sb.append(seperator);
            }
            sb.append(data[i]);
        }
        return sb.toString();
    }

    /**
     * 按照指定位数生成随机数字字符串
     */
    public static String randomNumber(int digits) {

        ThreadLocalRandom random = ThreadLocalRandom.current();

        StringBuilder result = new StringBuilder();
        while (digits > 0) {

            result.append(random.nextInt(10));
            digits--;
        }
        return result.toString();
    }

    public static String createLinkString(Map<String, Object> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        StringBuffer linkStr = new StringBuffer();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = (String) params.get(key);
            if (value == null) {
                continue;
            }
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个字符
                linkStr.append(key).append("=").append(value);
            } else {
                linkStr.append(key).append("=").append(value).append("&");
            }
        }
        return linkStr.toString();
    }

    /**
     * 通过身份证号取得性别
     *
     * @param idNo 身份证号
     * @return 性别，1，男，2，女，9，身份证错误
     */
    public static int getSexFromID(String idNo) {
        if (idNo.trim().length() != 18) {
            return 9;
        }
        int sex = (int) idNo.charAt(16);

        if (sex % 2 == 0) {// 判断性别
            return 2;
        }
        return 1;
    }

    /**
     * 把指定的数字转换成指定长度的字符串，左边补0，如果长度不够
     *
     * @param num 数值
     * @param length 字符串长度
     */
    public static String expandToLength(int num, int length) {
        if (Integer.toString(num).length() > length) {
            logger.error("illegal argument: {}, length: {}", num, length);
            throw new IllegalArgumentException("num " + num + " over length: " + length);
        }

        String format = "%0" + Integer.toString(length) + "d";
        return String.format(format, num);
    }

    /**
     * 通过身份证号截取出生日期
     *
     * @param idNo
     * @return
     */
    public static String getBirthFromID(String idNo){
        if(idNo.trim().length() == 18){
            return idNo.substring(6,14);
        }else if(idNo.trim().length() == 15){
            return "19"+idNo.substring(6,12);
        }else{
            return "00000000";
        }
    }

    /**
     * 通过身份证号截取年龄
     *
     * @param idNo
     * @return
     */
    public static String getAgeFromID(String idNo){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int bothYear = 0;
        if(idNo.trim().length() == 18){
            bothYear = Integer.parseInt(idNo.substring(6,10));
            return String.valueOf(year - bothYear);
        }else{
            return "0";
        }
    }

}
