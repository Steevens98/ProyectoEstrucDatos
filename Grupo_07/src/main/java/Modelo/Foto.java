
package Modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Foto {
    private String ruta;  // Ej: "ruta/foto1.jpg"
    private String descripcion;
    private LocalDate fechaCreacion;

    public Foto(String ruta) {
        this.ruta = Objects.requireNonNull(ruta, "La ruta no puede ser nula");
        this.fechaCreacion = LocalDate.now();
    }

    // Getters y Setters (encapsulamiento)
    public String getRuta() {
        return ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Para comparar fotos por ruta (usado en GestorFotos)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Foto otraFoto = (Foto) obj;
        return ruta.equals(otraFoto.ruta);
    }

    @Override
    public int hashCode() {
        return ruta.hashCode();
    }

    @Override
    public String toString() {
        return "Foto{" +
               "ruta='" + ruta + '\'' +
               ", fecha=" + fechaCreacion +
               '}';
    }
}
