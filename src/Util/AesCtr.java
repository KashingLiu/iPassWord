package Util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AesCtr {
    private static final byte[] ASE_KEY = {
            (byte)0x24, (byte)0xb1, (byte)0xf7, (byte)0x74,
            (byte)0xac, (byte)0x09, (byte)0xac, (byte)0x0b,
            (byte)0xc8, (byte)0xe7, (byte)0x6b, (byte)0xf5,
            (byte)0x66, (byte)0x05, (byte)0xc8, (byte)0xff
    };
    public static final String VIPARA = "0UOZo$md0hdcKohp";

    private static final String bm = "UTF-8";
    public static String encrypt(String cleartext) {
        try {
            SecretKeySpec key = new SecretKeySpec(ASE_KEY, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(VIPARA.getBytes()));
            byte[] encryptedData = cipher.doFinal(cleartext.getBytes(bm));
            return new BASE64Encoder().encode(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String encrypted) {
        try {
            byte[] byte_secret = new BASE64Decoder().decodeBuffer(encrypted);
            SecretKeySpec key = new SecretKeySpec(ASE_KEY, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(VIPARA.getBytes()));
            byte[] decryptedData = cipher.doFinal(byte_secret);
            return new String(decryptedData, bm);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main() throws Exception {
        String content = "kashingliu";
        // 加密
        System.out.println("加密前：" + content);
        String encryptResult = encrypt(content);

        System.out.println("加密后：" + encryptResult);
//         解密
        String decryptResult = decrypt(encryptResult);
        System.out.println("解密后：" + decryptResult);

    }
}