package com.example.hashjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class HashController {
    @FXML
    private Label translatedHash;
    @FXML
    private TextField inputHash;
    @FXML
    private Parent root;
    HashMap<String, String> dictionary;

    @FXML
    protected void onSubmitButtonClick() {
        try {
            if(dictionary == null || dictionary.isEmpty()) {
                throw new FileNotFoundException("You must upload a valid text file.");
            }

            translatedHash.setText(HashModel.convertToString(inputHash.getText(), dictionary));
        } catch (NullPointerException e) {
            //TODO: POP UP BOX
            System.out.println(e.getMessage());
        } catch (Exception e) {
            //TODO: POP UP BOX
            System.out.println("An unexpected error occurred: " + e.getClass().getCanonicalName());
        }
    }

    @FXML
    protected void onUploadFileClick() {
        Stage stage = (Stage) root.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        File file;

        fileChooser.getExtensionFilters().add(fileExt);
        file = fileChooser.showOpenDialog(stage);

        try {
            dictionary = HashModel.generateMD5Map(file);
        } catch (FileNotFoundException e) {
            dictionary = null;
            //TODO: POP UP BOX
            System.out.println("Please provide a valid test file");
        } catch (Exception e) {
            dictionary = null;
            //TODO: POP UP BOX
            System.out.println("An unexpected error occurred: " + e.getClass().getCanonicalName());
        }
    }
}