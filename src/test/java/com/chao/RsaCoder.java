package com.chao;

import com.google.gson.Gson;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

/**
 * 加解密工具 RSA
 */
public final class RsaCoder {
    /**
     *
     */
    public static final String KEY_ALGORITHM = "RSA";
//    public static final String KEY_ALGORITHM = "ECC";
//	private static final String PUBLIC_KEY = "RsaPublicKey";
//	private static final String PRIVATE_KEY = "RsaPrivateKey";

    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK6P7ZO9nFl5M1Ybcx4F4FRtRZA2R60KEGlzETQ7xYwUA2McppZxtJmxpQePdun8PyQxznTwexDwnlXbJ4Cz9k9Ip+ZL7J8zeiPaRDNjRori3iYSYJ51UANDbl5ty2MK6bznyMVyxcDiKFgRc+V5BPS+F5pH6NDJb6S5bDrszk6/AgMBAAECgYB/4A2xAeCsJr41oOwmnTVlg5rG9wxwtYOqS9HZisO/RtXoYA+k++zJ/jmfnTgGVnPGxvmv7o6orSvAR0fb33laCxccTApqztL0aVRk0IiDH4DK8dV7O2IWFUawfjiQKSCDgbWI7zcdoOgUz15OxuhBUXYlB10fHIVcGxUbFI08aQJBAN2NK/R1hfflW1I682uemmBoSuYwJ93nPBhHoWXTlyaYcWme4UJXG5A4BW3hwC2Q7DacmHy1Hqix/8XCV4BV85UCQQDJtFsOsOmbvumvsvYWm8SB0ilqerc0PKJr6Ixy3sqF6mjTJnAbCeMH8ue5J9F0DFLU2wNXvtXO9iyljJS8faQDAkEAu8Qkh4d+5ezNa7CokwIVRjW9nL8dWpTaOp2irQEZrk0ueVx8/tOCecTw3QKh9DxJ5bLsDW0XMdPBuOIPdKXjzQJAVg2UK5hekgvJNyRqyQp7s8ct1De2oZqc0NzNztQuIyP2xN7JRT/alDGVmvDZ82CulhE6Q90u6rUsJxTq/9+6cQJBAKKKvOm7m5oexiHEhVQw3QQ0M8mmHK7j4li8AQkheSWgGVtR7Kz905H1w4qFQGnWsmBga8qVFSGYn96jtIrCs+s=";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuj+2TvZxZeTNWG3MeBeBUbUWQNketChBpcxE0O8WMFANjHKaWcbSZsaUHj3bp/D8kMc508HsQ8J5V2yeAs/ZPSKfmS+yfM3oj2kQzY0aK4t4mEmCedVADQ25ebctjCum858jFcsXA4ihYEXPleQT0vheaR+jQyW+kuWw67M5OvwIDAQAB";

    private final KeyFactory keyFactory;
    //
    private final PrivateKey priKey;
    private final PublicKey pubKey;

    public RsaCoder(String publicKey, String privateKey) throws Exception {
        keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        if (publicKey != null && publicKey.length() > 0) {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
                    Base64.getDecoder().decode(publicKey));
            pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
        } else {
            pubKey = null;
        }
        if (privateKey != null && privateKey.length() > 0) {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
                    Base64.getDecoder().decode(privateKey));
            priKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        } else {
            priKey = null;
        }
    }

    /**
     * @param encryptedDataInBase64
     * @return
     * @throws Exception
     */
    public String decryptByPrivateKey(String encryptedDataInBase64) throws Exception {
        //
        return decrypt(encryptedDataInBase64, priKey);
    }

    /**
     * @param encryptedDataInBase64
     * @return
     * @throws Exception
     */
    public String decryptByPublicKey(String encryptedDataInBase64) throws Exception {
        //
        return decrypt(encryptedDataInBase64, pubKey);
    }

    /**
     * @param data
     * @return
     * @throws Exception
     */
    public String encryptByPublicKey(String data) throws Exception {
        return encrypt(data, pubKey);
    }

    /**
     * @param data
     * @return
     * @throws Exception
     */
    public String encryptByPrivateKey(String data) throws Exception {
        return encrypt(data, priKey);
    }

    private String encrypt(String data, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    private String decrypt(String encryptedDataInBase64, Key key) throws NoSuchAlgorithmException,
            NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedDataInBase64)), StandardCharsets.UTF_8);
    }


    public static void main(String[] args) throws Exception {
        HashMap<String, String> param = new HashMap<>();
        param.put("videoId", "af2b021e680c9b5744bc60d8feced6ff");
        param.put("name", "0p;360p;265_0p");
        param.put("type", "MP4_ORIGIN_ZILI;MP4_360P;MP4_265B_NORMAL_ORIGIN");
        param.put("timeOut", "3600000");
        Gson gson = new Gson();
        String paramStr = gson.toJson(param);

        RsaCoder rsaCoder = new RsaCoder(PUBLIC_KEY, PRIVATE_KEY);

        String aaaaaabbbbb = rsaCoder.encryptByPrivateKey(paramStr);
        String s = rsaCoder.decryptByPublicKey(aaaaaabbbbb);
        System.out.println(s);
    }
}
