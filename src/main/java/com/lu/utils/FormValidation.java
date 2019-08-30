package com.lu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValidation {
	//验证日期是否为指定格式
    public static boolean isValidDate(String str,String pattern) {
    	//yyyy-MM-dd
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
    /**
     * 正则表达式验证字符串
     * @param str 需要验证的字符串
     * @param pattern 正则表达式
     * @return true 验证成功
     * @return false 验证失败
     */
    public static boolean verifyStringByPattern(String str,String pattern) {
    	Pattern p=Pattern.compile(pattern);
    	Matcher m = p.matcher(str);
    	return m.matches();
    }
}
