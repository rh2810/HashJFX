package com.example.hashjfx;

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

/**
 * This class represents the Model unit. It performs much of
 * the core logic for the application. Data is passed to this class
 * by the Controller, which is transformed/utilized and then passed back.
 */
public class HashModel {

    private static final String MD5_REFERENCE =
            "https://stackoverflow.com/questions/40503201/decode-md5-ecnrytion-in-java";

    /**
     * Translate/Decode the given MD5 hash into its respective string.
     *
     * @param md5  The hash to be decoded
     * @param dict The dictionary to be used as reference for decoding
     * @return The decoded string
     * @throws Exception Checks for illegal arguments in input or dictionary
     */
    protected static String decodeMD5(String md5, HashMap<String, String> dict) throws Exception {
        String decodedHash;

        // Ensure that the given string is an MD5 hash value
        if (md5 == null || md5.length() != 32 || !md5.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("Please provide a valid md5 hash as input.");
        }

        decodedHash = dict.get(md5);

        // Input is not valid entry in dictionary
        if (decodedHash == null) {
            throw new NoSuchElementException("The given input is not an entry of the provided dictionary file.");
        }

        return decodedHash;
    }

    /**
     * Encodes given file strings into their respective MD5 Hash.
     * Then, pairs them in a HashMap dictionary.
     * <p>
     * References used : {@value #MD5_REFERENCE lines 88-92}
     *
     * @param file File that will be translated
     * @return HashMap of all translated lines in the provided file
     * @throws Exception Checks for illegal file types
     */
    protected static HashMap<String, String> generateMD5Map(File file) throws Exception {
        Scanner fd;
        HashMap<String, String> dictionary = new HashMap<>();
        String data;
        String md5Hash;

        try {
            // Ensure that a file exists and is a text file
            if (file != null && !file.getName().endsWith(".txt")) {
                throw new FileNotFoundException();
            }

            fd = new Scanner(file);

            // Read through the file
            while (fd.hasNextLine()) {
                data = fd.nextLine();

                // Set up a new MD5 instance digest
                MessageDigest digest = MessageDigest.getInstance("MD5");
                // Update input string in message digest
                digest.update(data.getBytes(), 0, data.length());
                // Converts message digest value in base 16 (hex)
                md5Hash = new BigInteger(1, digest.digest()).toString(16);

                dictionary.put(md5Hash, data);
            }

            fd.close();
        } catch (NullPointerException | FileNotFoundException e) {
            throw new FileNotFoundException("Please provide a valid text file.");
        }

        return dictionary;
    }

    /**
     * Generates a custom alert pop up for a given error message.
     *
     * @param alertMsg The message to be displayed
     * @return The new alert object
     */
    protected static Alert generateAlert(String alertMsg) {
        ButtonType okayButton = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        Label text = new Label(alertMsg);
        Alert alert;

        // Prepare the alert message and layout
        text.setText(alertMsg);
        text.setFont(Font.font("Cambria", FontWeight.BOLD, 14));
        HBox layout = new HBox(10, text);
        layout.setAlignment(Pos.CENTER);

        // Set the content for the alert
        alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Error");
        alert.getDialogPane().setPadding(new Insets(15));
        alert.getDialogPane().getButtonTypes().add(okayButton);
        alert.getDialogPane().setContent(layout);

        return alert;
    }
}
