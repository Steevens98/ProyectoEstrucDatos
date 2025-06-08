

package Modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class ImagenEscritor {


    public static void objetoAArchivo(byte[] datos, String rutaSalida) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(rutaSalida))) {
            fos.write(datos);
        }
    }
}

