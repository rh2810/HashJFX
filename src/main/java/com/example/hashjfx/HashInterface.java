package com.example.hashjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Welcome to HashJFX! This class initializes the HashJFX program,
 * which takes an MD5 hash and decodes it using a referenced dictionary file.
 */
public class HashInterface extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HashInterface.class.getResource("hashjfx-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 200);
        stage.setTitle("HashJFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}