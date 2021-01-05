package com.chao.sign;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class GoogleTokenTest {

    static String googlePublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC2+Y3bpSlpDLzfmatc8CwfllqIhM0qUWFF4abFq5RU3l4e/ze3m5fYzUk0Nm71QDe3cbG6y4YhtGDeZKxAOMmWxefvY3W9VUmbDHgJ9dY3nHLftktLkADrYJQsmur5fa7kFm5Gt2kGMos0nVdbeTnuOkAPBN3CnuZwWaB0JfUnOwIDAQAB";

    public static void main(String[] args) {
        String types = "avthumb/mp4/vcodec/libx265/crf/28/maxrate/2300k/bufsize/1000k/moovToFront/1/s/1280x720/autoscale/1/stripmeta/0;MP4_360P";
        String names = "265_720p_1;360p_1";
        String videoId = "67655513728019456018c0f1da831777";

        String token = genToken(types, names, videoId);
        System.out.println(videoId);
        System.out.println(token);

    }

    private static String genToken(String types, String names, String videoId) {
        Map<String, String> data = new HashMap<>();
        data.put("type", types);
        data.put("name", names);
        data.put("videoId", videoId);
        // 3、报文加密生成token；
        Gson gson = new Gson();
        String dataJson = gson.toJson(data);
        String token = "";
        try {
            token = RSACoder.encryptAndBase64ByPublicKey(dataJson, googlePublicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }
}
