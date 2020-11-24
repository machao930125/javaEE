package com.chao.sign;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeTest {
    public static void main(String[] args) {
        try {
            String encode = URLEncoder.encode("www.baidu.com;www.google.com", "UTF-8");
            String decode = URLDecoder.decode("www.baidu.com;www.google.com", "UTF-8");
            System.out.println(encode + ":"+decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
