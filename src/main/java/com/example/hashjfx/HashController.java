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
import java.io.IOException;

public class HashController {
    @FXML
    private Label translateHash;

    @FXML
    private TextField inputHash;
    @FXML
    private FileChooser fileChooser;

    private File file;

    @FXML
    protected void onSubmitButtonClick() {
        try {
//            translateHash.setText(HashModel.convertToString(inputHash.getText(), file));
            translateHash.setText(file.getAbsolutePath());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onUploadFileClick(ActionEvent event) {
        Node source = (Node) event.getSource();
        Window stage = source.getScene().getWindow();
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter fileExt = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");

        fileChooser.getExtensionFilters().add(fileExt);
        file = fileChooser.showOpenDialog(stage);
    }
}