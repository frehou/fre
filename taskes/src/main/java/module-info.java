module com.example.taskes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taskes to javafx.fxml;
    opens ai to javafx.fxml;
    exports ai;
    exports com.example.taskes;
}