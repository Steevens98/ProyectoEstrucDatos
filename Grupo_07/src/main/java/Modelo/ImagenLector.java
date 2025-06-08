package Modelo;

import javafx.scene.image.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImagenLector {
//Aqui lo que aremos sera guardar una imagen en un objeto en este caso datos
    // Convierte un archivo de imagen a un arreglo de bytes (objeto serializable)
    public static byte[] archivoAObjeto(File archivo) throws IOException {
        try (FileInputStream fis = new FileInputStream(archivo)) {
            byte[] datos = new byte[(int) archivo.length()];
            fis.read(datos);
            return datos;
        }
    }
//Se a añadido un public static imagen
    // Convierte un arreglo de bytes (objeto) a un objeto Image de JavaFX
    public static Image objetoAImagen(byte[] datos) {
        ByteArrayInputStream bis = new ByteArrayInputStream(datos);
        return new Image(bis);
    }
}

