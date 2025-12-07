package org.example.jnote.Primary;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.example.jnote.AccessLayer;
import org.example.jnote.Enums.IJNButtonEnum;
import org.example.jnote.Managers.ButtonManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrimaryMenu {
    private List<Button> _optionList;

    public void initMenuOptions() {
        ButtonManager btnMgr = AccessLayer.DI.resolve(ButtonManager.class);
        _optionList = new ArrayList<>();
        _optionList.add((btnMgr.getInstance("File", IJNButtonEnum.Other)));
        _optionList.add((btnMgr.getInstance("Tools", IJNButtonEnum.Other)));
        _optionList.add((btnMgr.getInstance("Help", IJNButtonEnum.Other)));
        _optionList.add((btnMgr.getInstance("Search", IJNButtonEnum.Other)));

        //todo - move them to a sub menu
        _optionList.add((btnMgr.getInstance("Save", IJNButtonEnum.Save)));
        _optionList.add((btnMgr.getInstance("Open", IJNButtonEnum.Open)));
    }


    public List<Button> GetOptions() {
        return _optionList;
    }

}
