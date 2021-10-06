package ua.leshchenko.rijndael;

import ua.leshchenko.utils.Utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Vitalii Leshchenko on 26.10.2017.
 */
public class Runner {

    public Runner() {
    }

    public static void main(String[] args) {

        // key
        byte[] key = "KPI".getBytes();

        // secret data
        String test = "12345678";
        byte[] tBytes = test.getBytes();

        // encoder
        Rijndael encoder = new Rijndael();
        List<byte[]> chunks = Utils.chunk(tBytes);
        List<byte[]> encrypted = new ArrayList<>();
        for (byte[] current : chunks) {
            encrypted.add(encoder.encrypt(key, current));

        }

        for (int i = 0; i < encrypted.size(); i++) {
            for (int j = 0; j < encrypted.get(i).length; j++) {
                System.out.print(encrypted.get(i)[j]+" ");
            }

        }
        System.out.println();
        
        // decoder
        Rijndael decoder = new Rijndael();
        try {
            String decryptedTestString = "";
            for (byte[] temporary : encrypted) {
                byte[] decryptedBytes = decoder.decrypt(key, temporary);
                decryptedTestString += new String(decryptedBytes, "UTF-8");
            }
            System.out.println("Result value >>> " + decryptedTestString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}