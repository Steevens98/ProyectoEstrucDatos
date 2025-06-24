
package Modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
/**
 * Clase Foto. Representa una entidad del sistema.
 */
public class Foto {
    private String ruta;
    private String descripcion;
    private LocalDate fechaCreacion;
    
    public Foto(String ruta, LocalDate fechaCreacion) {
        this.ruta = Objects.requireNonNull(ruta, "La ruta no puede ser nula");
        this.fechaCreacion = fechaCreacion;
    }

    public Foto(String ruta) {
        this(ruta, LocalDate.now());
    }

    // Getters y Setters (encapsulamiento)
/**
 * Método getRuta. Implementa una operación específica.
 */
    public String getRuta() {
        return ruta;
    }

/**
 * Método getDescripcion. Implementa una operación específica.
 */
    public String getDescripcion() {
        return descripcion;
    }

/**
 * Método setDescripcion. Implementa una operación específica.
 */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

/**
 * Método getFechaCreacion. Implementa una operación específica.
 */
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    // Para comparar fotos por ruta (usado en GestorFotos)
    @Override
/**
 * Método equals. Implementa una operación específica.
 */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Foto otraFoto = (Foto) obj;
        return ruta.equals(otraFoto.ruta);
    }

    @Override
/**
 * Método hashCode. Implementa una operación específica.
 */
    public int hashCode() {
        return ruta.hashCode();
    }

    @Override
/**
 * Método toString. Implementa una operación específica.
 */
    public String toString() {
        return "Foto{" +
               "ruta='" + ruta + '\'' +
               ", fecha=" + fechaCreacion +
               '}';
    }
}