
package com.mycompany.proyecto;

public class NodoDobleCircular<T> {
    T dato;

    public NodoDobleCircular<T> siguiente;
    public NodoDobleCircular<T> anterior;
    
    public NodoDobleCircular(T dato) {
        this.dato = dato;
        this.siguiente = this;
        this.anterior = this;
    }
}
