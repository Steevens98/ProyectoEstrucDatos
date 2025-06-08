
package Modelo;

public class NodoDobleCircular<T> {
    public T dato;

    public NodoDobleCircular<T> siguiente;
    public NodoDobleCircular<T> anterior;
    
    public NodoDobleCircular(T dato) {
        this.dato = dato;
        this.siguiente = this;
        this.anterior = this;
    }
}
