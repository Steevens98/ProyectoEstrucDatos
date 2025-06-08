
package Modelo;

public class GestorContactos extends GestorBase<Contacto> {
    @Override
    protected boolean existe(Contacto contacto) {
        if (elementos.tamaño() == 0) return false;
        
        NodoDobleCircular<Contacto> actual = elementos.cabeza;
        do {
            if (actual.dato.getId().equals(contacto.getId())) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != elementos.cabeza);
        return false;
    }

    // Métodos específicos para contactos
    public Contacto buscarPorId(String id) {
        if (elementos.tamaño() == 0) return null;
        
        NodoDobleCircular<Contacto> actual = elementos.cabeza;
        do {
            if (actual.dato.getId().equals(id)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        } while (actual != elementos.cabeza);
        return null;
    }
}
