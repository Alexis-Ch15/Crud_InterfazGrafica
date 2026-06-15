package org.example.crudinterfaz;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AdministradorController {

    @FXML private BorderPane contenedorPrincipal;
    private void cargarVista(String fxmlArchivo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlArchivo));
            Parent vistaHija = loader.load();
            contenedorPrincipal.setCenter(vistaHija);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al cargar la vista: " + fxmlArchivo);
        }
    }
    public void btnProductos()
    {
        cargarVista("productos.fxml");
    }

}
