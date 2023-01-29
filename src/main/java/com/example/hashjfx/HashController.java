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

public class HashController {
    @FXML
    private Label translatedHash;
    @FXML
    private TextField inputHash;
    @FXML
    private Label fileName;
    @FXML
    private Parent root;
    private static File file = null;
    private Alert alert;
    private HashMap<String, String> dictionary;

    @FXML
    protected void onSubmitButtonClick() {
        try {
            if (dictionary == null || dictionary.isEmpty()) {
                throw new FileNotFoundException("You must first upload a valid text file.");
            }

            translatedHash.setText(HashModel.convertToString(inputHash.getText(), dictionary));
        } catch (NullPointerException e) { // Caught if the user does not provide any input.
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (FileNotFoundException e) { // Caught if user has not uploaded a text file.
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (NoSuchElementException e) { // Caught if given input does not exist in uploaded file.
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) { // Caught if an unknown error occurs.
            alert = HashModel.generateAlert("An unexpected error occurred: " + e.getClass().getCanonicalName());
            alert.showAndWait();

        }
    }

    @FXML
    protected void onUploadFileClick() {
        Stage stage = (Stage) root.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        File currentFile = file;

        fileChooser.getExtensionFilters().add(fileExt);
        file = fileChooser.showOpenDialog(stage);

        if(file == null)
            file = currentFile;

        try {
            if(file != null && !file.equals(currentFile)) {
                dictionary = HashModel.generateMD5Map(file);
                fileName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
                fileName.setText(file.getName());
            }
        } catch (FileNotFoundException e) {
            dictionary = null;
            alert = HashModel.generateAlert(e.getMessage());
            alert.showAndWait();

        } catch (Exception e) {
            dictionary = null;
            alert = HashModel.generateAlert("An unexpected error occurred: " + e.getClass().getCanonicalName());
            alert.showAndWait();

        }
    }
}