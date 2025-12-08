module org.example.jnote {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.jnote to javafx.fxml;
    exports org.example.jnote;
}