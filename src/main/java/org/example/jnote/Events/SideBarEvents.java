package org.example.jnote.Events;

import javafx.scene.layout.VBox;
import org.example.jnote.AccessLayer;
import org.example.jnote.Common.IJNoteSideBar.DirectoryOrFile;

import java.io.File;

public class SideBarEvents {
    public static void Load(){
        AccessLayer.sideBar.getChildren().clear();
        Load(AccessLayer.sideBar, AccessLayer.file);
    }

    public static void Load(VBox sideBar, File fileOrDir){
        boolean isFile = fileOrDir.isFile();
        String name = fileOrDir.getName();
        DirectoryOrFile obj = new DirectoryOrFile(name, isFile);
        sideBar.getChildren().add(obj);

        if(isFile) {
            return;
        }

        for(var subFile : fileOrDir.listFiles()){
            Load(sideBar, subFile);
        }
    }
}
