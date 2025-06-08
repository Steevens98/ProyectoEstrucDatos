
package Modelo;

public class PersonaNatural extends Contacto{
    
    public PersonaNatural(String id, String nombre, String telefono, String email, String pais, String apellido, String FechaNacimiento) {
        super(id,nombre,telefono,email,pais);
        // Asigna valores a los atributos
        editarAtributo(TipoAtributo.APELLIDO, apellido);
        editarAtributo(TipoAtributo.FECHA_NACIMIENTO, FechaNacimiento);
    }

    @Override
    protected void inicializarAtributosEspecificos() {
        editarAtributo(TipoAtributo.APELLIDO, null);
        editarAtributo(TipoAtributo.FECHA_NACIMIENTO, null);
    }
    
}
