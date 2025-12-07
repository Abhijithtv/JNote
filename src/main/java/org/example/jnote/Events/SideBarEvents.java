package org.example.jnote.Events;

import org.example.jnote.AccessLayer;
import org.example.jnote.Common.IJNoteSideBar.DirectoryOrFile;

public class SideBarEvents {
    public static void Load(){
        DirectoryOrFile dof1 = new DirectoryOrFile("File1.txt", false);
        DirectoryOrFile dof2 = new DirectoryOrFile("Dir1", false);
        AccessLayer.sideBar.getChildren().clear();
        AccessLayer.sideBar.getChildren().addAll(dof1, dof2);
    }
}
