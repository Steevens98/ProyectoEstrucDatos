package Modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Contacto {
    private String id;
    private ListaDobleCircular<Foto> fotos;
    private Map<TipoAtributo, Atributo> atributos;  // Clave: nombre del atributo (ej: "Teléfono")

    public Contacto(String id) {
        this.id = id;
        this.atributos = new HashMap<>();
        this.fotos = new ListaDobleCircular<>();
        // Inicializar TODOS los atributos (generales + específicos) en el constructor
        inicializarAtributos();
    }
    private void inicializarAtributos() {
        // Atributos generales (Single Responsibility)
        for (TipoAtributo tipo : TipoAtributo.values()) {
            if (tipo.esGeneral()) {
                atributos.put(tipo, new Atributo(tipo, ""));
            }
        }
        // Atributos específicos (Liskov Substitution)
        inicializarAtributosEspecificos();
    }
    
    //Atributos especificos deberan ser instanciados obligatoriamente en las clases donde se heradan
    protected abstract void inicializarAtributosEspecificos();
    
    public void editarAtributo(TipoAtributo tipo, String nuevoValor) {
        if (atributos.containsKey(tipo)) {
            atributos.get(tipo).setValor(nuevoValor);
        } else {
            throw new IllegalArgumentException("Atributo no permitido: " + tipo.name());
        }
    }
    
    public String getValorAtributo(TipoAtributo tipo) {
        return atributos.get(tipo) != null ? atributos.get(tipo).getValor() : null;
    }

    public String getId() {
        return id;
    }

    public ListaDobleCircular<Foto> getFotos() {
        return fotos;
    }

    public Map<TipoAtributo, Atributo> getAtributos() {
        return atributos;
    }
    
    public void setId(String nombre) {
        this.id = id;
    }

    public void setFotos(ListaDobleCircular<Foto> fotos) {
        this.fotos = fotos;
    }

    public void setAtributos(Map<TipoAtributo, Atributo> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "Contacto{" + "id=" + id + ", atributos=" + atributos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Contacto other = (Contacto) obj;
        if (!this.id.equals(other.id)) {
            return false;
        }
        return this.atributos.equals(other.atributos);
    }
    
    


    
}
