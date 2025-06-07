package com.mycompany.proyecto;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class MainViewController{
    
    @FXML
    private void onCreatePersonContact() throws IOException {
        App.tipoContactoSeleccionado = "persona";
        App.setRoot("secondary");
    }

    @FXML
    private void onCreateCompanyContact() throws IOException {
        App.tipoContactoSeleccionado = "empresa";
        App.setRoot("secondary");
    }

    
}
    

