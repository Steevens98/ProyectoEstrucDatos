
package Modelo;
public abstract class GestorBase<T> {
    public ListaDobleCircular<T> elementos;

    public GestorBase() {
        this.elementos = new ListaDobleCircular<>();
    }

    // Operaciones CRUD básicas (template method)
    public final void agregar(T elemento) {
        if (!existe(elemento)) {
            elementos.agregar(elemento);
        }
    }

    public final boolean eliminar(T elemento) {
        return elementos.eliminar(elemento);
    }

    // Método abstracto para búsqueda específica
    protected abstract boolean existe(T elemento);

    // Navegación circular (comportamiento compartido)
    public final T siguiente(T actual) {
        NodoDobleCircular<T> nodo = encontrarNodo(actual);
        return nodo != null ? nodo.siguiente.dato : null;
    }

    public final T anterior(T actual) {
        NodoDobleCircular<T> nodo = encontrarNodo(actual);
        return nodo != null ? nodo.anterior.dato : null;
    }

    private NodoDobleCircular<T> encontrarNodo(T elemento) {
        if (elementos.tamaño() == 0) return null;
        
        NodoDobleCircular<T> actual = elementos.cabeza;
        do {
            if (actual.dato.equals(elemento)) {
                return actual;
            }
            actual = actual.siguiente;
        } while (actual != elementos.cabeza);
        return null;
    }
}
