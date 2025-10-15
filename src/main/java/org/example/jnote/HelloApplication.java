package org.example.jnote;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.jnote.Primary.PrimaryStageManager;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        PrimaryStageManager.GetInstance()
                .setStage(stage)
                .setTitle("JNote")
                .loadControls()
                .setScene()
                .show();
    }

    public static void main(String[] args) {
        launch();
    }
}