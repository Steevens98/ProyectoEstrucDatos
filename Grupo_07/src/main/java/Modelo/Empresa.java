
package Modelo;


public class Empresa extends Contacto{
        public Empresa(String nombre, String telefono, String email, String pais, String rubro, String numeroEmpresa) {
        super(nombre,telefono,email,pais);
        // Asigna valores a los atributos
        editarAtributo(TipoAtributo.RUBRO, rubro);
        editarAtributo(TipoAtributo.DIRECCION_EMPRESA, numeroEmpresa);
    }
        
    @Override
    protected void inicializarAtributosEspecificos() {
        editarAtributo(TipoAtributo.RUBRO, null);
        editarAtributo(TipoAtributo.DIRECCION_EMPRESA, null);
    }
}
