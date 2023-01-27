package com.example.hashjfx;
//REF: https://stackoverflow.com/questions/40503201/decode-md5-ecnrytion-in-java


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;

public class HashModel {
    public static String convertToString(String md5, File file) throws Exception{
        String string = null;

        // TODO: Make parameter that passes the absolute location to the file
//        File fd = new File();

        if(md5 == null) {
            return null;
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
}
