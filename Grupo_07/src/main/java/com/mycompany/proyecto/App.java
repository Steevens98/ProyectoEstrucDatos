package com.mycompany.proyecto;

import Modelo.Contacto;
import Modelo.ListaDobleCircular;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
/**
 * Clase App. Representa una entidad del sistema.
 */
public class App extends Application {

    private static Scene scene;

    @Override
/**
 * Método start. Implementa una operación específica.
 */
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainView"), 640, 560);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}