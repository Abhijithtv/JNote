package org.example.jnote.Primary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.jnote.AccessLayer;

import javax.swing.*;

public class PrimaryStageManager {
    private final PrimaryMenu _primaryMenu;
    private final PrimaryTextArea _primaryTextArea;
    private static volatile PrimaryStageManager _primaryStageManager;
    private Stage _stage;

    private PrimaryStageManager(){
        _primaryMenu = new PrimaryMenu();
        _primaryTextArea = new PrimaryTextArea();
        AccessLayer.primaryTextArea = _primaryTextArea;
    }

    public static PrimaryStageManager GetInstance(){
        if(_primaryStageManager!=null) return _primaryStageManager;

        synchronized(PrimaryStageManager.class){
            if(_primaryStageManager!=null) return _primaryStageManager;

            _primaryStageManager = new PrimaryStageManager();

            return _primaryStageManager;
        }
    }

    public PrimaryStageManager setStage(Stage stage){
        this._stage = stage;
        AccessLayer.stage = stage;
        return this;
    }


    public PrimaryStageManager loadControls(){
        _primaryMenu.initMenuOptions();
        _primaryTextArea.initTextArea();
        _loadSidebar();
        return this;
    }

    private void _loadSidebar() {
        var sideBar = new VBox();
        sideBar.setPrefWidth(150);
        sideBar.setStyle("-fx-background-color: #333;");
        AccessLayer.sideBar = sideBar;
    }

    public PrimaryStageManager setTitle(String title){
        _stage.setTitle(title);
        return this;
    }

    public void show(){
        this._stage.show();
    }


    public PrimaryStageManager setScene(){
        HBox menuBox = _getMenuBox();
        AnchorPane textBox = _getTextBoxPane();

        VBox vBox = new VBox();
        vBox.getChildren().add(menuBox);

        HBox directoryAndTextarea = new HBox();
        HBox.setHgrow(textBox, Priority.ALWAYS);

        directoryAndTextarea.getChildren().addAll(AccessLayer.sideBar, textBox);

        vBox.getChildren().add(directoryAndTextarea);
        VBox.setVgrow(directoryAndTextarea, Priority.ALWAYS);

        _stage.setScene(new Scene(vBox));
        return this;
    }

    private HBox _getMenuBox(){
        HBox menuBox = new HBox();
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        menuBox.getChildren().addAll(_primaryMenu.GetOptions());
        menuBox.getChildren().add(spacer);
        return menuBox;
    }

    private AnchorPane _getTextBoxPane(){
        var textArea = _primaryTextArea.getPrimaryTextArea();
        AnchorPane root = new AnchorPane(textArea);
        AnchorPane.setTopAnchor(textArea, 0.0);
        AnchorPane.setBottomAnchor(textArea, 0.0);
        AnchorPane.setLeftAnchor(textArea, 0.0);
        AnchorPane.setRightAnchor(textArea, 0.0);
        return root;
    }

}
