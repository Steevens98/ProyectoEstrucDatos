
package Modelo;

public class PersonaNatural extends Contacto{
    
    public PersonaNatural(String nombre, String telefono, String email, String pais, String apellido, String FechaNacimiento) {
        super(nombre,telefono,email,pais);
        // Asigna valores a los atributos
        editarAtributo(TipoAtributo.APELLIDO, apellido);
        editarAtributo(TipoAtributo.FECHA_NACIMIENTO, FechaNacimiento);
    }

    @Override
    protected void inicializarAtributosEspecificos() {
       // atributos.put(TipoAtributo.APELLIDO, null);
       // atributos.put(TipoAtributo.FECHA_NACIMIENTO, null);
        atributos.put(TipoAtributo.APELLIDO, new Atributo(TipoAtributo.APELLIDO, null));
        atributos.put(TipoAtributo.FECHA_NACIMIENTO, new Atributo(TipoAtributo.FECHA_NACIMIENTO, null));
    }
    
}
