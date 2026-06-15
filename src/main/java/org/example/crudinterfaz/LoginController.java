package org.example.crudinterfaz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private TextField txtClave;
    @FXML private ComboBox<String> roles;
    @FXML private Label lblMensaje;

    @FXML
    public void btnNuevo() throws IOException {
        String user = txtUsuario.getText();
        String clave = txtClave.getText();
        String opciones = roles.getValue();
        if(opciones == null || user.trim().isEmpty()|| clave.trim().isEmpty()){
            lblMensaje.setText("No puede dejar cmapos sin llenar");
            return;
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/crudinterfaz/menu.fxml"));
        Parent root = loader.load();
        Stage nuevaVentana = new Stage();
        nuevaVentana.setScene(new Scene(root));
        nuevaVentana.show();
        Stage ventanaActual = (Stage) txtUsuario.getScene().getWindow();
        ventanaActual.close();
    }
    @FXML
    public void initialize(){
        roles.getItems().addAll("Administrador","Cajero","Vendedor");
    }
}
