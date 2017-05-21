package com.weixin.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurtityUtils {

    public static String sha1(String str) {
        try {
            StringBuffer sb = new StringBuffer();
            MessageDigest md = MessageDigest.getInstance("sha1");
            md.update(str.getBytes());
            byte[] msg = md.digest();
            for (byte m : msg) {
                sb.append(String.format("%02x", m));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(SecurtityUtils.sha1("hello"));
    }

}
