
package Modelo;

public class GestorFotos extends GestorBase<Foto> {
    @Override
    protected boolean existe(Foto foto) {
        // Implementación específica para fotos (comparar por ruta, hash, etc.)
        if (elementos.tamaño() == 0) return false;
        
        NodoDobleCircular<Foto> actual = elementos.cabeza;
        do {
            if (actual.dato.getRuta().equals(foto.getRuta())) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != elementos.cabeza);
        return false;
    }

    // Método específico para fotos
    public void agregarFotoContacto(Contacto contacto, Foto foto) {
        contacto.getFotos().agregar(foto);
        this.agregar(foto); // Opcional: mantener registro global
    }
}
