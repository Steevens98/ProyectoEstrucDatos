/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyecto;

import Modelo.Contacto;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
/**
 * Clase CreateEmpresaController. Representa una entidad del sistema.
 */
public class CreateEmpresaController{

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtRubro;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtDireccionEmpresa;
    @FXML
    private ImageView imagenContacto;
    @FXML
    private Button btnSeleccionarImagen;
    private File archivoImagenSeleccionada;
    
    @FXML
/**
 * Método guardarEnArchivo. Implementa una operación específica.
 */
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
        String id = Contacto.generarId();
        String linea = String.format("empresa,%s,%s,%s,%s,%s,%s,%s%n",
                id , nombre, telefono, mail, pais, rubro, direccionEmpresa ,System.lineSeparator());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recursos/usuarios.txt", true))) {
            writer.write(linea);
            mostrarMensaje("Datos guardados correctamente.");
        } catch (IOException e) {
            mostrarMensaje("Error al guardar los datos: " + e.getMessage());
        }
        
        if (archivoImagenSeleccionada != null) {
            String nombreOriginal = archivoImagenSeleccionada.getName(); // ejemplo: "foto.png"
            File carpetaImagenes = new File("imagenes/");

            // Crear el directorio si no existe
            if (!carpetaImagenes.exists()) {
                carpetaImagenes.mkdirs();
            }

            File destino = new File(carpetaImagenes, nombreOriginal);

            // Si ya existe un archivo con ese nombre, renombrarlo
            int contador = 1;
            String nombreSinExtension = nombreOriginal.substring(0, nombreOriginal.lastIndexOf('.'));
            String extension = nombreOriginal.substring(nombreOriginal.lastIndexOf('.'));

            while (destino.exists()) {
                String nuevoNombre = nombreSinExtension + "_" + contador + extension;
                destino = new File(carpetaImagenes, nuevoNombre);
                contador++;
            }

            try {
                // Copiar la imagen seleccionada al destino
                Files.copy(archivoImagenSeleccionada.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

                // Escribir en el archivo imagenes.txt
                try (BufferedWriter fotoWriter = new BufferedWriter(new FileWriter("recursos/imagenes.txt", true))) {
                    String rutaRelativa = "imagenes/" + destino.getName(); // lo que usarás al cargar
                    String fechaHoy = java.time.LocalDate.now().toString();
                    fotoWriter.write(id + "," + rutaRelativa + "," + fechaHoy + System.lineSeparator());
                }

            } catch (IOException ex) {
                mostrarMensaje("Error al copiar la imagen: " + ex.getMessage());
            }
        }
        limpiarCampos();
        
    }
    
    @FXML
/**
 * Método seleccionarImagen. Implementa una operación específica.
 */
    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            archivoImagenSeleccionada = file;
            Image image = new Image(file.toURI().toString());
            imagenContacto.setImage(image);
        }
    }
    
    // Método para mostrar un cuadro de diálogo con un mensaje
/**
 * Método mostrarMensaje. Implementa una operación específica.
 */
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método opcional para limpiar los campos después de guardar
/**
 * Método limpiarCampos. Implementa una operación específica.
 */
    private void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        txtMail.clear();
        txtPais.clear();
        txtRubro.clear();
        txtDireccionEmpresa.clear();
        imagenContacto.setImage(null);// Borra la imagen del ImageView
        archivoImagenSeleccionada = null;// Borra la referencia al archivo seleccionado
    }
    
    @FXML
/**
 * Método SwitchCancelar. Implementa una operación específica.
 */
    private void SwitchCancelar() throws IOException {
        App.setRoot("createContact");
    }
    
}
