package org.example.jnote.Primary;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import org.example.jnote.AccessLayer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrimaryMenu {
    private List<Button> _optionList;
  /*  private String[] _options = new String[]{
            "File",
            "Tools",
            "Help",
            "Search",
            "Open",//todo - remove
            "Save"//todo - remove
    };*/

    public void initMenuOptions() {
//        _optionList = Arrays.stream(_options)
//                .map(option -> new Button(option))
//                .toList();
        _optionList = new ArrayList<>();
        _optionList.add(new Button("File"));
        _optionList.add(new Button("Tools"));
        _optionList.add(new Button("Help"));
        _optionList.add(new Button("Search"));

// later move them
        var save = new Button("Save");
        _optionList.add(save);
        var open = new Button("Open");
        _optionList.add(open);

        save.setOnAction(x-> {
            var file = AccessLayer.file;
            try {
                writeToFile(file, AccessLayer.primaryTextArea.getPrimaryTextArea().getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        open.setOnAction(x -> {
            try {
                triggerOpen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void writeToFile(File file, String text) throws IOException {
        var fileObj = Path.of(file.getPath());
        Files.writeString(fileObj, text);
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
                        System.out.println(line);
                        AccessLayer.primaryTextArea.getPrimaryTextArea().appendText(line);
                    });
        }
    }

    public List<Button> GetOptions() {
        return _optionList;
    }

}
