package org.example.jnote.Common.IJNoteButtons;

import javafx.stage.DirectoryChooser;
import org.example.jnote.AccessLayer;
import org.example.jnote.Common.IJNoteButton;
import org.example.jnote.Events.SideBarEvents;

import java.io.File;
import java.io.IOException;

public class OpenFolderButton extends IJNoteButton {
    public OpenFolderButton(String name){
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
        DirectoryChooser dirChooser = new DirectoryChooser();
        File folder = dirChooser.showDialog(AccessLayer.stage);

        if(folder == null || !folder.canRead()){
            return;
        }

        AccessLayer.file = folder;
        AccessLayer.primaryTextArea.getPrimaryTextArea().clear();

        //todo - make it async
        SideBarEvents.Load();
    }
}
