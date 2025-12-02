package org.example.jnote.Common.IJNoteButtons;

import javafx.stage.FileChooser;
import org.example.jnote.AccessLayer;
import org.example.jnote.Common.IJNoteButton;
import org.example.jnote.Enums.IJNButtonEnum;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpenButton extends IJNoteButton {
    public OpenButton(String name){
        super(name);
    }

    @Override public void fire(){
        try {
            triggerOpen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.fire();
    }

    private void triggerOpen() throws IOException {
        FileChooser fil_chooser = new FileChooser();
        var file = fil_chooser.showOpenDialog(AccessLayer.stage);
        if(file != null && file.canRead()){
            AccessLayer.file = file;
            AccessLayer.primaryTextArea.getPrimaryTextArea().clear();
            Files.lines(Path.of(file.getPath()))
                    .forEach(x-> {
                        var line = new String(x.getBytes(StandardCharsets.UTF_8));
                        AccessLayer.primaryTextArea.getPrimaryTextArea().appendText(line);
                    });
        }
    }
}
