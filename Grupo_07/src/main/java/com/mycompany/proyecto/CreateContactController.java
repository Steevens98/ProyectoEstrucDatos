package com.mycompany.proyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
/**
 * Clase CreateContactController. Representa una entidad del sistema.
 */
public class CreateContactController {

    @FXML
/**
 * Método switchToCreateNaturalPerson. Implementa una operación específica.
 */
    private void switchToCreateNaturalPerson() throws IOException {
        App.setRoot("createNaturalPerson");
    }

    @FXML
/**
 * Método switchToCreateEmpresa. Implementa una operación específica.
 */
    private void switchToCreateEmpresa() throws IOException {
        App.setRoot("createEmpresa");
    }
    
    @FXML
/**
 * Método switchAtras. Implementa una operación específica.
 */
    private void switchAtras() throws IOException {
        App.setRoot("mainView");
    }
    
}
