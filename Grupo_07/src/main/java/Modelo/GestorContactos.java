
package Modelo;

public class GestorContactos {
    private final ListaDobleCircular<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new ListaDobleCircular<>();
    }

    // CRUD
    public void agregarContacto(Contacto contacto) {
        if (!existeContacto(contacto.getId())) {
            contactos.agregar(contacto);
        }
    }

    private boolean existeContacto(String id) {
        if (contactos.tamaño() == 0) return false;
        
        NodoDobleCircular<Contacto> actual = contactos.cabeza;
        do {
            if (actual.dato.getId().equals(id)) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != contactos.cabeza);
        return false;
    }

    // Búsqueda circular
    public Contacto buscarContacto(String id) {
        if (contactos.tamaño() == 0) return null;
        
        NodoDobleCircular<Contacto> actual = contactos.cabeza;
        do {
            if (actual.dato.getId().equals(id)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        } while (actual != contactos.cabeza);
        return null;
    }

    // Navegación circular
    public Contacto siguienteContacto(Contacto actual) {
        NodoDobleCircular<Contacto> nodo = encontrarNodo(actual);
        return nodo != null ? nodo.siguiente.dato : null;
    }

    public Contacto anteriorContacto(Contacto actual) {
        NodoDobleCircular<Contacto> nodo = encontrarNodo(actual);
        return nodo != null ? nodo.anterior.dato : null;
    }

    private NodoDobleCircular<Contacto> encontrarNodo(Contacto contacto) {
        if (contactos.tamaño() == 0) return null;
        
        NodoDobleCircular<Contacto> actual = contactos.cabeza;
        do {
            if (actual.dato.equals(contacto)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != contactos.cabeza);
        return null;
    }
}
