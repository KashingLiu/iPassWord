package Util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TestAes {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] key = {
                (byte)0x24, (byte)0xb1, (byte)0xf7, (byte)0x74,
                (byte)0xac, (byte)0x09, (byte)0xac, (byte)0x0b,
                (byte)0xc8, (byte)0xe7, (byte)0x6b, (byte)0xf5,
                (byte)0x66, (byte)0x05, (byte)0xc8, (byte)0xff
        };
        String content = ".kashingliu521.1";
//        if (content.length()<=16) {
            int add = 16-(content.length()%16);
            System.out.println(add);
//            String temp = "";
//            String add = Integer.toString(16-content.length());
//            for (int i = 0; i<16-content.length(); i++) {
//                temp = temp.concat(add);
//            }
//            content = content.concat(temp);
//        }

        //加密后产生的密文，是byte数组
        byte[] fine = MyAES.encipher(content.getBytes(),MyAES.keyExpansion(key));

        for (byte i : fine) {
            System.out.print(i);
        }


        System.out.println();
        byte[] out = MyAES.decipher(fine,MyAES.keyExpansion(key));
        for (byte i : out) {
            System.out.print(i);
        }
        String out_str = new String(out);
        System.out.println(out_str);
        System.out.println(out_str.charAt(out_str.length()-1));


//        final Base64.Decoder decoder = Base64.getDecoder();
//        final Base64.Encoder encoder = Base64.getEncoder();
//编码
//        final String encodedText = encoder.encodeToString(fine);
//        System.out.println(encodedText);
//解码
//        String out = new String(decoder.decode(encodedText));
//        byte[] out_byte = out.getBytes();
//        for (byte i : out_byte) {
//            System.out.print(i);
//        }
//
//        byte[] source = MyAES.decipher(out_byte,MyAES.keyExpansion(key));
//        for (byte i:source) {
//            System.out.print(i);
//        }







//        String mid = Base64.getEncoder().encodeToString(fine);
//        System.out.println(mid);
//        String out = Base64.getDecoder().decode();
//        for (byte i : fine) {
//            System.out.print((char)i);
//        }
//        System.out.println();
//        byte[] fu = MyAES.decipher(fine,MyAES.keyExpansion(key));
//        for (byte j: fu) {
//            System.out.print((char)j);
//        }
//        byte[] encode = AesCtr.encode(content.getBytes("utf-8"), key, AesEnum.KEY128);
//        char[] encode_char = new char[encode.length];
//        for (int i = 0; i< encode.length; i++) {
//            encode_char[i] = (char)encode[i];
//        }
//        String mid =
//
//        System.out.println(mid);
//
//        byte[] decode = AesCtr.decode(encode, key, AesEnum.KEY128);
//        System.out.println(new String(decode, "UTF-8"));
    }
}
