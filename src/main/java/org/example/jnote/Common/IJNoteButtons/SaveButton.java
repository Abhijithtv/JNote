package org.example.jnote.Common.IJNoteButtons;

import org.example.jnote.AccessLayer;
import org.example.jnote.Common.IJNoteButton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SaveButton extends IJNoteButton {
    public SaveButton(String name){
        super(name);
    }

    @Override
    public void fire(){
        var file = AccessLayer.file;
        try {
            writeToFile(file, AccessLayer.primaryTextArea.getPrimaryTextArea().getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        super.fire();
    }

    private void writeToFile(File file, String text) throws IOException {
        var fileObj = Path.of(file.getPath());
        Files.writeString(fileObj, text);
    }

}
