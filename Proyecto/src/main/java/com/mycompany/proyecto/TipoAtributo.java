
package com.mycompany.proyecto;

public enum TipoAtributo {
     // Atributos GENERALES (comunes a todos)
    NOMBRE(true),
    TELEFONO(true),
    EMAIL(true),
    PAIS(true),
    
    // Atributos ESPECÍFICOS de PersonaNatural
    APELLIDO(false),
    FECHA_NACIMIENTO(false),
    
    // Atributos ESPECÍFICOS de Empresa
    RUBRO(false),
    DIRECCION_EMPRESA(false);

    private final boolean esGeneral;

    TipoAtributo(boolean esGeneral) {
        this.esGeneral = esGeneral;
    }

    public boolean esGeneral() {
        return esGeneral;
    }
}
