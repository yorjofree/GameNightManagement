module com.freiorio.gamenightmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;


    opens com.freiorio.gamenightmanagement to javafx.fxml;
    exports com.freiorio.gamenightmanagement;
}