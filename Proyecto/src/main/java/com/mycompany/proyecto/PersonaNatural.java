
package com.mycompany.proyecto;

public class PersonaNatural extends Contacto{
    
    public PersonaNatural(String id, String apellido, String FechaNacimiento) {
        super(id);
        // Setear valores iniciales
        editarAtributo(TipoAtributo.APELLIDO, apellido);
        editarAtributo(TipoAtributo.FECHA_NACIMIENTO, FechaNacimiento);
    }

    @Override
    protected void inicializarAtributosEspecificos() {
        editarAtributo(TipoAtributo.APELLIDO, null);
        editarAtributo(TipoAtributo.FECHA_NACIMIENTO, null);
    }
    
}
