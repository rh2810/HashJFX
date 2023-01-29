package com.example.hashjfx;
//REF: https://stackoverflow.com/questions/40503201/decode-md5-ecnrytion-in-java


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Scanner;

public class HashModel {
    public static String convertToString(String md5, HashMap<String, String> dict) throws Exception {
        String decodedHash;

        if (md5 == null || md5.equals("")) {
            throw new NullPointerException("Input cannot be empty.");
        }

        decodedHash = dict.get(md5);

        return decodedHash;
    }

    public static HashMap<String, String> generateMD5Map(File file) throws Exception {
        Scanner fd;
        HashMap<String, String> dictionary = new HashMap<>();
        String data;
        String md5Hash;

        try {
            if (file != null && !file.getName().endsWith(".txt")) {
                throw new FileNotFoundException();
            }

            fd = new Scanner(file);

            while (fd.hasNextLine()) {
                data = fd.nextLine();

                MessageDigest digest = MessageDigest.getInstance("MD5");
                // Update input string in message digest
                digest.update(data.getBytes(), 0, data.length());
                // Converts message digest value in base 16 (hex)
                md5Hash = new BigInteger(1, digest.digest()).toString(16);

                dictionary.put(md5Hash, data);

                System.out.println(data + ": " + md5Hash);
            }

            fd.close();
        } catch (NullPointerException | FileNotFoundException e) {
            throw new FileNotFoundException();
        }

        return dictionary;
    }
}
