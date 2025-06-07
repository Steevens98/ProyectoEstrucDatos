
package Modelo;

public class Atributo {
    private TipoAtributo clave;   // Ej: "Teléfono", "Email", "País"
    private String valor;   // Ej: "0991234567", "juan@example.com"

    public Atributo(TipoAtributo clave, String valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public TipoAtributo getClave() {
        return clave;
    }

    public String getValor() {
        return valor;
    }

    public void setClave(TipoAtributo clave) {
        this.clave = clave;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Atributo other = (Atributo) obj;
        
        if (!other.clave.equals(this.clave)) {
            return false;
        }
        return other.valor.equals(this.valor);
    }
    
    
}
