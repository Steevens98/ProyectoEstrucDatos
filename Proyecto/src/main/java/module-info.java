module com.mycompany.proyecto {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.proyecto to javafx.fxml;
    exports com.mycompany.proyecto;
}
