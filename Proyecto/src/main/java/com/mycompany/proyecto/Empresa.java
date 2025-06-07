
package com.mycompany.proyecto;

public class Empresa extends Contacto{
        public Empresa(String id, String rubro, String numeroEmpresa) {
        super(id);
        editarAtributo(TipoAtributo.RUBRO, rubro);
        editarAtributo(TipoAtributo.DIRECCION_EMPRESA, numeroEmpresa);
    }
        
    @Override
    protected void inicializarAtributosEspecificos() {
        editarAtributo(TipoAtributo.RUBRO, null);
        editarAtributo(TipoAtributo.DIRECCION_EMPRESA, null);
    }
}
