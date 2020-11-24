package com.chao.sign;

import com.chao.RsaCoder;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.HashMap;

public class RSACoder {

    public static final String KEY_ALGORITHM = "RSA";

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC+lV4asFZKYr6It1WWb7sLI6hG\n" +
            "+ulRqi6ggPfrCkcwMC/lDkK2c1sMt1WQly2Q546tfEIDCCg/lYBFuegcz5GWkD6G\n" +
            "ee3pxteOEmgI4Ry0GtnF6tWcKZHu4zNMF0umdBfQ7RWpZ7CBmc6tiydV5KCfH/Ri\n" +
            "etPsJlREhCBsBIHa+wIDAQAB";
    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAL6VXhqwVkpivoi3\n" +
            "VZZvuwsjqEb66VGqLqCA9+sKRzAwL+UOQrZzWwy3VZCXLZDnjq18QgMIKD+VgEW5\n" +
            "6BzPkZaQPoZ57enG144SaAjhHLQa2cXq1Zwpke7jM0wXS6Z0F9DtFalnsIGZzq2L\n" +
            "J1XkoJ8f9GJ60+wmVESEIGwEgdr7AgMBAAECgYB3OS3DeGii5B7ZnAcYsxDJqSbO\n" +
            "MIzhH5tHoSZ2jNl31c1Ad6lYRdXBoLcQWuKQcasZ8E/DYcj77eRuuhvwWhFykLGf\n" +
            "tb9q1jwrPEx8skoG/c9CdSlTWsU8hhUx1/CZoLc46Sd0cqWqB2iR9bIRJD/Lcv95\n" +
            "lh0RzEpp42NmNjaAEQJBAN1I2S7loLAvpC4xSPAISvu19UKpetl7u8lDGYnyM5Bv\n" +
            "cfIA8tUde65Qf6Pj3l79hNQGT5WI4m7kikuZ9wVzRq8CQQDce4NC0gg9A5gqE2a+\n" +
            "nzyAZeohct+vhP0eP5/OYuSJwsLpJTAYv8cCUWZZbrWDNWGjUXDC28RI8zqz7X0q\n" +
            "iYN1AkEAnf0wCvqpwoERQGWxxKa3GoXsSR8F9hcQmP6OUl4ZkKrw+K7SsXPuZSNW\n" +
            "LmY30yxAVLz4vzPPLwt+7cFMi5ilQwJAD3ZJ+kGoej7qSOkbZ3rbT1XWWYoozbJR\n" +
            "3fEwT9T3mgGikZ8eBF5Ooob62oK9D/qKYl2vvrqSxVrpXvzkrjr+kQJAFGkoXlwh\n" +
            "JHTL7dD9WSi3uLlYWOIKUS+SHyPjhOhnroG4IJX7EM+v44asgslDq8t/ycp5jmCP\n" +
            "/alRyCf0872aiQ==";

    public static void main(String[] args) throws Exception {
        HashMap<String, String> param = new HashMap<>();
        param.put("videoId", "af2b021e680c9b5744bc60d8feced6ff");
        param.put("url", "www.baidu.com/af2b021e680c9b5744bc60d8feced6ff.0p");
        param.put("bitRate", "123");
        Gson gson = new Gson();
        String paramStr = gson.toJson(param);


//        String encryptAndBase64ByPublicKey = RSACoder.encryptAndBase64ByPublicKey(paramStr, publicKey);
//
//        System.out.println(encryptAndBase64ByPublicKey);
//
//        String de = RSACoder.decryptBase64AndRSAByPrivateKey(encryptAndBase64ByPublicKey, privateKey);
//        System.out.println(de);

        String content = "FFNCba+xT/EmqU9jBVv6qpjBuIOqdJvzsEypYaSFM55DTe6Qqzr92oDzUltUkBcF3/nArSCSq+2RbEqPd8Eljhx8HJYEwIrc+ZvBcbfw7EpIeZCdeH59cfQj2gDDLUQPlise8sqiyFNBB7OOw9mz1OhfBK0lUSi/dr73WSgOKxE=";
        String s = RSACoder.decryptBase64AndRSAByPrivateKey(content, privateKey);
        System.out.println(s);
    }


    /**
     * 私钥解密 返回字符串
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptBase64AndRSAByPrivateKey(String data, String privateKey) throws Exception {
        return new String(decryptByPrivateKey(RSACoder.decryptBASE64(data), privateKey));
    }

    /**
     * 公钥加密 返回base64字符串
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptAndBase64ByPublicKey(String data, String key) throws Exception {
        return encryptBASE64(encryptByPublicKey(data, key));
    }

    /**
     * 使用私钥解密
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, Key privateKey) throws Exception {
        // 对数据解密
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] inputArray = data;
        int inputLength = inputArray.length;
        // 最大加密字节数，超出最大字节数需要分组加密
        int MAX_ENCRYPT_BLOCK = 128;
        // 标识
        int offSet = 0;
        byte[] resultBytes = {};
        byte[] cache = {};
        while (inputLength - offSet > 0) {
            if (inputLength - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(inputArray, offSet, MAX_ENCRYPT_BLOCK);
                offSet += MAX_ENCRYPT_BLOCK;
            } else {
                cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                offSet = inputLength;
            }
            resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
            System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
        }
        return resultBytes;
    }

    public static byte[] decryptByPrivateKey(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        return decryptByPrivateKey(data, privateKey);
    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(String data, String key) throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] inputArray = data.getBytes();
        int inputLength = inputArray.length;
        // 最大加密字节数，超出最大字节数需要分组加密
        int MAX_ENCRYPT_BLOCK = 117;
        // 标识
        int offSet = 0;
        byte[] resultBytes = {};
        byte[] cache = {};
        while (inputLength - offSet > 0) {
            if (inputLength - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(inputArray, offSet, MAX_ENCRYPT_BLOCK);
                offSet += MAX_ENCRYPT_BLOCK;
            } else {
                cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                offSet = inputLength;
            }
            resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
            System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
        }
        return resultBytes;
    }

    public static byte[] decryptBASE64(String key) {
        return Base64.decodeBase64(key.getBytes());
    }

    public static String encryptBASE64(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }


}