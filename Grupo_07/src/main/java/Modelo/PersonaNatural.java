
package Modelo;

/**
 *
 * @author Usuario
 */
/**
 * Clase PersonaNatural. Representa una entidad del sistema.
 */
public class PersonaNatural extends Contacto{
    private String apellido;
    private String fechaNacimiento;

    public PersonaNatural(String id,String nombre, String apellido, String telefono, String email, String pais, String fechaNacimiento) {
        super(id,nombre, telefono, email, pais);
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

/**
 * Método getApellido. Implementa una operación específica.
 */
    public String getApellido() {
        return apellido;
    }

/**
 * Método setApellido. Implementa una operación específica.
 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

/**
 * Método getFechaNacimiento. Implementa una operación específica.
 */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

/**
 * Método setFechaNacimiento. Implementa una operación específica.
 */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
/**
 * Método toString. Implementa una operación específica.
 */
    public String toString() {
        return super.toString() + ", apellido='" + apellido + '\'' + ", fechaNacimiento='" + fechaNacimiento + '\'';
    }
    
}
