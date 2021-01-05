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
        genCdnCallback();
    }

    private static void genCdnCallback(){
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("url", "0000.0p;222.3p");
        treeMap.put("bitRate", "127;23");
        treeMap.put("videoId", "03091813d4c5a2f0cf95e37ef8b6bd01");
        String sign = getSign(treeMap);
        System.out.println(sign);
    }


    private static String getSign(TreeMap<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            sb.append(param.getKey()).append("=").append(param.getValue()).append("&");
        }

        StringBuilder builder = new StringBuilder(sb);

        builder.append("key=").append("3d5f1ffeadf58eb64ef57aef7e53a31e");
        String sign = null;
        try {
            sign = hexMD5(builder.toString());
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
