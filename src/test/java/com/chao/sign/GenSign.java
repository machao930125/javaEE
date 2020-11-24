package com.chao.sign;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class GenSign {
    // version_code=20200809&server_code=1&timestamp=1&r=IN&uId=900927b92cf5ac8d&count=10&l=en&group=1
    public static void main(String[] args) {
        String time = System.currentTimeMillis() + "";
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("r", "IN");
        treeMap.put("l", "IN");
        treeMap.put("topicKey", "fun");
        treeMap.put("docId", "22222222");
        treeMap.put("uuid", "222222222");
        treeMap.put("timestamp", time);
        treeMap.put("version_code", "20190729");
        treeMap.put("server_code", "100");
        treeMap.put("userId", "25da2383a78ef2a1");
        treeMap.put("group", "1");
        treeMap.put("count", "10");
        treeMap.put("passport", "boss");
        String sign = getSign(treeMap);
        System.out.println(sign);
    }
    private static String getSign(TreeMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            sb.append(param.getKey()).append("=").append(param.getValue()).append("&");
        }

        sb.append("key=").append("3d5f1ffeadf58eb64ef57aef7e53a31e");
        String sign = null;
        try {
            sign = hexMD5(sb.toString());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sb.append("&sign=").append(sign);
        return sb.toString();
    }

    private static String hexMD5(String value)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(value.getBytes("utf-8"));
        byte[] digest = messageDigest.digest();
        return Hex.encodeHexString(digest);
    }
}
