package com.example.hashjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashController {
    @FXML
    private Label translateHash;
    @FXML
    private TextField inputHash;
    @FXML
    private FileChooser fileChooser;
    HashMap<String, String> dictionary;

    @FXML
    protected void onSubmitButtonClick() {
        try {
            if(dictionary == null || dictionary.isEmpty()) {
                throw new FileNotFoundException("You must upload a valid text file.");
            }

            translateHash.setText(HashModel.convertToString(inputHash.getText(), dictionary));
        } catch (Exception e) {
            //TODO: POP UP BOX FOR EACH INSTANCE
            switch (e.getClass().getCanonicalName()){
                case "java.lang.NullPointerException":
                    System.out.println("The input field cannot be empty.");
                    break;
                case "java.io.FileNotFoundException":
                    System.out.println(e.getMessage());
                    break;
            }
            System.out.println(e.getClass().getCanonicalName());
        }
    }

    @FXML
    protected void onUploadFileClick(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        File file;


        fileChooser.getExtensionFilters().add(fileExt);
        file = fileChooser.showOpenDialog(stage);

        try {
            dictionary = HashModel.generateMD5Map(file);
        } catch (Exception e) {
            dictionary = null;
            //TODO: POP UP BOX
            System.out.println("An unexpected error occurred: " + e.getClass().getCanonicalName());
        }
    }
}