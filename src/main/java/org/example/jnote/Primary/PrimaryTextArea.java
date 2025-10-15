package org.example.jnote.Primary;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class PrimaryTextArea {
    private TextArea primaryTextArea;

    public void initTextArea(){
        primaryTextArea = new TextArea();
    }

    public TextArea getPrimaryTextArea(){
        return primaryTextArea;
    }
}
