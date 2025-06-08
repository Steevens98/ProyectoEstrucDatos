/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class CreateEmpresaController{
    @FXML private TextField txtNombre;
    @FXML private TextField txtRubro;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtMail;
    @FXML private TextField txtPais;
    @FXML private TextField txtDireccionEmpresa;
    
    @FXML
    private void guardarEnArchivo() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String mail = txtMail.getText().trim();
        String pais = txtPais.getText().trim();
        String rubro = txtRubro.getText().trim();
        String direccionEmpresa = txtDireccionEmpresa.getText().trim();

        // Validación básica (opcional)
        if (nombre.isEmpty() || telefono.isEmpty() || mail.isEmpty() || pais.isEmpty() || rubro.isEmpty() || direccionEmpresa.isEmpty()) {
            mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        String linea = String.format("empresa,%s,%s,%s,%s,%s,%s%n",
                nombre, telefono, mail, pais, rubro, direccionEmpresa ,System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recursos/usuarios.txt", true))) {
            writer.write(linea);
            mostrarMensaje("Datos guardados correctamente.");
            limpiarCampos();
        } catch (IOException e) {
            mostrarMensaje("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    // Método para mostrar un cuadro de diálogo con un mensaje
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método opcional para limpiar los campos después de guardar
    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        txtMail.clear();
        txtPais.clear();
        txtRubro.clear();
        txtDireccionEmpresa.clear();
    }
    
    @FXML
    private void SwitchAtras() throws IOException {
        App.setRoot("createContact");
    }
    
}
