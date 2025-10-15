module org.example.jnote {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.jnote to javafx.fxml;
    exports org.example.jnote;
}