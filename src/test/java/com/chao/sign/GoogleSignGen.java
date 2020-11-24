package com.chao.sign;

import com.google.gson.Gson;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.Map;
import java.util.TreeMap;

public class GoogleSignGen {

    static String signKey = "3d5f1ffeadf58eb64ef57aef7e53a31e";

    public static void main(String[] args) {
        Map<String, String> params = new TreeMap<>();
        params.put("videoId","65798599347989504c9f8740e097b9c3");
//        params.put("timestamp", System.currentTimeMillis() + "");
        params.put("key", signKey);

        Gson gson = new Gson();
        String json = gson.toJson(params);
        String token = DigestUtils.md5Hex(json);
        System.out.println(token);

    }
}
