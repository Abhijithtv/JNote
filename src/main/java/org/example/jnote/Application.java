package org.example.jnote;

import javafx.stage.Stage;
import org.example.jnote.Primary.PrimaryStageManager;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        new StartUp().build();
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