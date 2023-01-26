module com.example.hashjfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.hashjfx to javafx.fxml;
    exports com.example.hashjfx;
}