package org.example.jnote.Builders;

import org.example.jnote.Common.IJNoteButton;
import org.example.jnote.Common.IJNoteButtons.*;
import org.example.jnote.Enums.IJNButtonEnum;

public class ButtonBuilder {
    public static IJNoteButton  GetInstance(IJNButtonEnum type, String name) throws Exception {
        IJNoteButton btn = null;
        switch (type){
            case IJNButtonEnum.Save:
                btn = new SaveButton(name);
                break;
            case IJNButtonEnum.Close:
                btn = new CloseButton(name);
                break;
            case IJNButtonEnum.Other:
                btn = new DynamicButton(name);
                break;
            case IJNButtonEnum.Open:
                btn = new OpenButton(name);
                break;
            case IJNButtonEnum.OpenFolder:
                btn = new OpenFolderButton(name);
                break;
            default:
                throw new Exception("Unknown Button Type");
        }

        return btn;
    }

}
