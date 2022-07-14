package com.demo.mybatis;

/**
 * 192.168.3.4
 */
public class TestString {
    public static final String POINTER = ".";

    public static void main(String[] args) {

    }

    public static boolean isIp(String ipStr) {
        if (ipStr == null || ipStr.length() < 7) {
            return false;
        }
        //点不在尾部
        if (ipStr.startsWith(POINTER) || ipStr.endsWith(POINTER)) {
            return false;
        }
        //
        int pointerCount = 0, length = ipStr.length(), pointIndex = 0;
        for (int i = 0; i < length; i++) {
            String s = ipStr.charAt(i) + "";
            if (s.equals(POINTER)) {
                pointerCount++;
                //判断点重复在一起
                if (pointIndex != 0 && pointIndex == i - 1) {
                    return false;
                }
                pointIndex = i;
                continue;
            }
            if (!isNumber(s)) {
                return false;
            }
        }
        if (pointerCount != 3) {
            return false;
        }
        return true;

    }

    /**
     * 判断时候为整数
     *
     * @param s 字符串数值
     */
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;


    }
}
