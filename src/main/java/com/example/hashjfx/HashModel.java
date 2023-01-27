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
        String string = null;

        if (md5 == null || md5.equals("")) {
            throw new NullPointerException("Input is empty.");
        }

        if (OSChecker.isWindows()) {
            System.out.println("Is Windows!");
//            string = md5;

        } else if (OSChecker.isLinux()) {
            System.out.println("Is Linux!");
            // well. do the same thing but with grep LOL

        } else {
            throw new UnsupportedOperationException("This program is not compatible with the current operating system.");
        }

        MessageDigest digest = MessageDigest.getInstance("MD5");
        // Update input string in message digest
        digest.update(md5.getBytes(), 0, md5.length());
        // Converts message digest value in base 16 (hex)
        md5 = new BigInteger(1, digest.digest()).toString(16);

        System.out.println(md5);

        return md5;
    }

    public static HashMap<String, String> generateMD5Map(File file) throws Exception {
        Scanner fd;

        try {
            if (file != null && !file.getName().endsWith(".txt")) {
                throw new FileNotFoundException();
            }

            fd = new Scanner(file);

            while (fd.hasNextLine()) {
                String data = fd.nextLine();
                System.out.println(data);
            }
            fd.close();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println("No file given.");
            return null;
        }

        return null;
    }
}
