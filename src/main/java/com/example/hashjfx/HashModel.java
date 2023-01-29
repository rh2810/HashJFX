package com.example.hashjfx;
//REF: https://stackoverflow.com/questions/40503201/decode-md5-ecnrytion-in-java
//REF: https://stackoverflow.com/questions/51883825/how-to-vertically-center-content-of-alert-dialogpane


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HashModel {
    public static String convertToString(String md5, HashMap<String, String> dict) throws Exception {
        String decodedHash;

        if (md5 == null || md5.length() != 32 || !md5.matches("[0-9a-fA-F]+")) {
            throw new NullPointerException("Please provide a valid md5 hash as input.");
        }

        decodedHash = dict.get(md5);

        if (decodedHash == null) {
            throw new NoSuchElementException("The given input is not a valid entry of the uploaded text file.");
        }

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
            throw new FileNotFoundException("Please provide a valid text file.");
        }

        return dictionary;
    }

    public static Alert generateAlert (String alertMsg) {
        ButtonType okayButton = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        Label text = new Label(alertMsg);
        Alert alert;

        text.setText(alertMsg);
        text.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        HBox content = new HBox(10, text);
        content.setAlignment(Pos.CENTER);

        alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Error");
        alert.getDialogPane().setPadding(new Insets(15));
        alert.getDialogPane().getButtonTypes().add(okayButton);

        alert.getDialogPane().setContent(content);

        return alert;
    }
}
