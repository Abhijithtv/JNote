package org.example.jnote.Builders;

import org.example.jnote.Common.IJNoteButton;
import org.example.jnote.Common.IJNoteButtons.CloseButton;
import org.example.jnote.Common.IJNoteButtons.DynamicButton;
import org.example.jnote.Common.IJNoteButtons.OpenButton;
import org.example.jnote.Common.IJNoteButtons.SaveButton;
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
            default:
                throw new Exception("Unknown Button Type");
        }

        return btn;
    }

}
