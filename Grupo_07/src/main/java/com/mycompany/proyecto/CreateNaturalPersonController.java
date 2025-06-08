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
public class CreateNaturalPersonController  {
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtTelefono;
    @FXML private DatePicker dateNacimiento;
    @FXML private TextField txtMail;
    @FXML private TextField txtPais;
    
    @FXML
    private void guardarEnArchivo() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String telefono = txtTelefono.getText().trim();
        LocalDate fecha = dateNacimiento.getValue();
        String fechaNacimiento = (fecha != null) ? fecha.toString() : "";
        String mail = txtMail.getText().trim();
        String pais = txtPais.getText().trim();

        // Validación básica (opcional)
        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaNacimiento.isEmpty() || mail.isEmpty() || pais.isEmpty()) {
            mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        String linea = String.format("persona,%s,%s,%s,%s,%s,%s%n",
                nombre, apellido, telefono, fechaNacimiento, mail, pais,System.lineSeparator());

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
        txtApellido.clear();
        txtTelefono.clear();
        dateNacimiento.setValue(null);
        txtMail.clear();
        txtPais.clear();
    }

    @FXML
    private void SwitchAtras() throws IOException {
        App.setRoot("createContact");
    }
    
}
