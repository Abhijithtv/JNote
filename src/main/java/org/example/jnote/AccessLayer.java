package org.example.jnote;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.example.jnote.Primary.PrimaryTextArea;

import java.io.File;

public class AccessLayer {
    public static Stage stage;
    public static PrimaryTextArea primaryTextArea;
    public static File file;
    public static DependencyResolver DI;
}
