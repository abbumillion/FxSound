module com.example.fxsound {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.fxsound to javafx.fxml;
    exports com.example.fxsound;
}