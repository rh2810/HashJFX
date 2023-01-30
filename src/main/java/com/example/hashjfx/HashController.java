package com.example.hashjfx;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * This class acts as the Controller unit. It sends/receives information
 * to/from the Model and Interface, modifying backend logic and front-end UI respectively.
 */
public class HashController {
    @FXML
    private Label translatedHash; // Label where the decoded hash is displayed
    @FXML
    private TextField inputHash; // Input field for the MD5 hash
    @FXML
    private Label fileName; // Label for displaying the loaded text file
    @FXML
    private Parent root; // Represents the parent component

    private static File file = null; // For keeping track of the current file
    private Alert alert; // Used for displaying alerts/errors to the user
    private HashMap<String, String> dictionary; // The

    /**
     * ActionListener for the submit button. This method initiates the md5
     * decoding process if the parameters have been met.
     */
    @FXML
    protected void onSubmitButtonClick() {
        try {
            if (dictionary == null || dictionary.isEmpty()) {
                throw new FileNotFoundException("You must first upload a valid text file.");
            }

            translatedHash.setText(HashModel.decodeMD5(inputHash.getText(), dictionary));
        } catch (IllegalArgumentException e) { // Caught if the user does not provide valid input
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (FileNotFoundException e) { // Caught if user has not uploaded a text file
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (NoSuchElementException e) { // Caught if given input does not exist in uploaded file
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) { // Caught if an unknown error occurs
            alert = HashModel.generateAlert("An unexpected error occurred: " + e.getClass().getCanonicalName());
            alert.showAndWait();

        }
    }

    /**
     * ActionListener for file upload selection. This method allows
     * user to select a file and then initializes the "string translation" process.
     */
    @FXML
    protected void onUploadFileClick() {
        Stage stage = (Stage) root.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        File currentFile = file;

        // User selects a file to be translated
        fileChooser.getExtensionFilters().add(fileExt);
        file = fileChooser.showOpenDialog(stage);

        // If there was no file selected, use the previously stored file
        if (file == null)
            file = currentFile;

        try {
            // Begin the translation process for a new file
            if (file != null && !file.equals(currentFile)) {
                dictionary = HashModel.generateMD5Map(file);
                fileName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                fileName.setText(file.getName());
            }
        } catch (FileNotFoundException e) { // Caught if an invalid file type was given
            dictionary = null;
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) { // Caught if an unknown error occurs
            dictionary = null;
            alert = HashModel.generateAlert("An unexpected error occurred: " + e.getClass().getCanonicalName());
            alert.showAndWait();

        }
    }
}