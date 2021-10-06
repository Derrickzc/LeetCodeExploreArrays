package ua.leshchenko.rijndael;

import ua.leshchenko.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CTRmodule {
    public static void main(String[] args) {
        //两个都是16字节长度的字符串
        String CTR1=getGUID();
        String CTR2=getGUID();
        //进入AES加密
        String Key1="123";
        byte[] code1=entry(CTR1,Key1);
        //这个是密文
        byte[] code2=entry(CTR2,Key1);

        //与一共32的位明文异或
        String Plaintxt="IloveEncryption!lovedeEncryption";
        System.out.println("原始明文为："+Plaintxt);
        byte[] plaintxt=Plaintxt.getBytes();
        byte[] cipher1=new byte[16];
        byte[] cipher2=new byte[16];
        for(int i=0;i<16;i++){
            cipher1[i]= (byte) (plaintxt[i]^code1[i]);
        }
        for (int i=0;i<16;i++){
            cipher2[i]=(byte)(plaintxt[16+i]^code2[i]);
        }
        ////////////////////////////////////////

        //显示密文 c1 c2
        System.out.println("密文分组1");
        System.out.println(new String(cipher1));
        System.out.println("密文分组2");
        System.out.println(new String(cipher2));
        ///////////////////////////
        //接下来开始解密 还原
        byte[] plaintxt1=new byte[16];
        byte[] plaintxt2=new byte[16];
        for(int i=0;i<16;i++){
            plaintxt1[i]=(byte) (cipher1[i]^code1[i] );
        }
        for (int i = 0; i < 16; i++) {
            plaintxt2[i]=(byte) (cipher2[i]^code2[i]);
        }
        ////////////////////////////
        System.out.println("解密后的明文1");
        System.out.println(new String(plaintxt1));
        System.out.println("解密后的明文2");
        System.out.println(new String(plaintxt2));


    }

    public static byte[] entry(String test,String Key1){
        byte[] key = Key1.getBytes();

        // secret data
        //String test = "12345678";
        byte[] tBytes = test.getBytes();

        // encoder
        Rijndael encoder = new Rijndael();
        List<byte[]> chunks = Utils.chunk(tBytes);
        List<byte[]> encrypted = new ArrayList<>();
        for (byte[] current : chunks) {
            encrypted.add(encoder.encrypt(key, current));

        }

//        for (int i = 0; i < encrypted.size(); i++) {
//            for (int j = 0; j < encrypted.get(i).length; j++) {
//                System.out.print(encrypted.get(i)[j]+" ");
//            }
//
//        }
       // System.out.println();

        // decoder
        Rijndael decoder = new Rijndael();
        String decryptedTestString = "";
        try {

            for (byte[] temporary : encrypted) {
                byte[] decryptedBytes = decoder.decrypt(key, temporary);
                decryptedTestString += new String(decryptedBytes, "UTF-8");
            }
            //System.out.println("Result value >>> " + decryptedTestString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] en1=encrypted.get(0);
        return  en1;
    }



    public static String getGUID() {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(3);
            switch (type) {
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char) (rd.nextInt(25) + 65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char) (rd.nextInt(25) + 97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }
    }
