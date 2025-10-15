package org.example.jnote.Primary;

import javafx.scene.Node;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class PrimaryMenu {
    private List<Node> _optionList;

    public void initMenuOptions() {
        _optionList = new ArrayList<>();
        _optionList.add(new Button("File"));
        _optionList.add(new Button("Tools"));
        _optionList.add(new Button("Help"));
        _optionList.add(new Button("Search"));
    }

    public List<Node> GetOptions() {
        return _optionList;
    }

}
