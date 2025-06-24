
package Modelo;


/**
 *
 * @author Usuario
 */
/**
 * Clase Empresa. Representa una entidad del sistema.
 */
public class Empresa extends Contacto{
    private String rubro;
    private String direccion;

    public Empresa(String id,String nombre, String telefono, String email, String pais, String rubro, String direccion) {
        super(id,nombre, telefono, email, pais);
        this.rubro = rubro;
        this.direccion = direccion;
    }

/**
 * Método getRubro. Implementa una operación específica.
 */
    public String getRubro() {
        return rubro;
    }

/**
 * Método setRubro. Implementa una operación específica.
 */
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

/**
 * Método getDireccion. Implementa una operación específica.
 */
    public String getDireccion() {
        return direccion;
    }

/**
 * Método setDireccion. Implementa una operación específica.
 */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
/**
 * Método toString. Implementa una operación específica.
 */
    public String toString() {
        return super.toString() + ", rubro='" + rubro + '\'' + ", direccion='" + direccion + '\'' + '}';
    }
    
}
