package org.example.jnote.Common.IJNoteSideBar;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import org.example.jnote.AccessLayer;

import java.io.File;
import java.util.Optional;

public class DirectoryOrFile extends HBox {
    private String _name;
    private boolean _isFile;
    private File _fileOrDir;


    public DirectoryOrFile(String name, boolean isFile){
        this._name = name;
        this._isFile = isFile;
        this._init();
    }


    private void _init() {
        _loadUIElements();
        _applyStyle();
    }

    private void _applyStyle() {
        this.setStyle(
                "-fx-padding: 6 8;" +
                        "-fx-background-color: #17468C;" +
                        "-fx-border-color: transparent;"
        );

        _openButton.ifPresent(button ->
                button.setStyle(
                        "-fx-background-color: #17468C;" +
                                "-fx-text-fill: white;" +
                                "-fx-border-color: transparent;"
                )
        );

        this._fileOrDirLabel.setStyle("-fx-text-fill: white;");
    }

    private Label _fileOrDirLabel;
    private Optional<Button> _openButton = Optional.empty();

    private void _loadUIElements() {
        _fileOrDirLabel = new Label(_name);
        this.getChildren().add(_fileOrDirLabel);

        if(_isFile){
           return;
        }
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        _openButton = Optional.of(new Button(">"));
        this.getChildren().addAll(spacer, _openButton.get());
    }
}
