module org.example.crudinterfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.crudinterfaz to javafx.fxml;
    exports org.example.crudinterfaz;
}