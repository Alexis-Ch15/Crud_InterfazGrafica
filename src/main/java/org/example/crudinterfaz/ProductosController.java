package org.example.crudinterfaz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductosController {
    @FXML private TextField txtNombre, txtCodigo, txtPrecio, txtStock, txtBuscar;
    @FXML private ComboBox<String> cmbCategoria, cmbEstado;
    @FXML private Label lblMensaje;
    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colCodigo, colNombre, colCategoria, colPrecio, colStock,colEstado;
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cmbCategoria.getItems().addAll("Comida", "Utiles Escolares", "Limpieza");
        cmbEstado.getItems().addAll("Activo", "Inactivo");

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));


        tablaProductos.setItems(listaProductos);
    }

    private boolean esValido() {
        if (txtNombre.getText().isEmpty() || txtCodigo.getText().isEmpty() ||
                txtPrecio.getText().isEmpty() || txtStock.getText().isEmpty() ||
                cmbCategoria.getValue() == null || cmbEstado.getValue() == null) {
            lblMensaje.setText("Error: Todos los campos son obligatorios.");
            return false;
        }
        return true;
    }

    @FXML
    public void btnGuardar() {
        if (!esValido()) return;

        try {
            double precio = Double.parseDouble(txtPrecio.getText());
            int stock = Integer.parseInt(txtStock.getText());

            Producto nuevo = new Producto(txtCodigo.getText(), txtNombre.getText(),
                    cmbCategoria.getValue(), precio, stock, cmbEstado.getValue());

            if (listaProductos.contains(nuevo)) {
                lblMensaje.setText("Error: El código ya existe.");
            } else {
                listaProductos.add(nuevo);
                lblMensaje.setText("Producto agregado correctamente.");
                btnLimpiar();
            }
        } catch (NumberFormatException e) {
            lblMensaje.setText("Error: Precio y Stock deben ser numéricos.");
        }
    }

    @FXML
    public void btnEliminar() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaProductos.remove(seleccionado);
            lblMensaje.setText("Producto eliminado.");
        } else {
            lblMensaje.setText("Seleccione un producto de la tabla primero.");
        }
    }

    @FXML
    public void btnLimpiar() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();
        cmbCategoria.setValue(null);
        cmbEstado.setValue(null);
        lblMensaje.setText("");
    }
    @FXML
    public void btnActualizar() {
        Producto p = tablaProductos.getSelectionModel().getSelectedItem();

        if (p == null) {
            lblMensaje.setText("Por favor, seleccione un producto de la tabla.");
            return;
        }

        if (!esValido()){
            return;
        }
        try {
            p.setNombre(txtNombre.getText());
            p.setCategoria(cmbCategoria.getValue());
            p.setPrecio(Double.parseDouble(txtPrecio.getText()));
            p.setStock(Integer.parseInt(txtStock.getText()));
            p.setEstado(cmbEstado.getValue());
            tablaProductos.refresh();
            lblMensaje.setText("Producto actualizado correctamente.");
            btnLimpiar();
        } catch (NumberFormatException e) {
            lblMensaje.setText("Error: Precio y Stock deben ser numéricos.");
        }
    }
    @FXML
    public void btnBuscar() {
        String busqueda = txtBuscar.getText().toLowerCase();

        if (busqueda.isEmpty()) {
            tablaProductos.setItems(listaProductos);
        } else {
            ObservableList<Producto> listadeseada = FXCollections.observableArrayList();
            for (Producto p : listaProductos) {
                if (p.getNombre().toLowerCase().contains(busqueda) || p.getCodigo().toLowerCase().contains(busqueda)) {
                    listadeseada.add(p);
                }
            }
            tablaProductos.setItems(listadeseada);
        }
    }
    public void btnNuevo(){
        btnLimpiar();
        txtCodigo.requestFocus();
    }
}