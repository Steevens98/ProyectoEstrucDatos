package com.mycompany.proyecto;

public class ListaDobleCircular<T> {


    private NodoDobleCircular<T> cabeza;
    public ListaDobleCircular() {
        this.cabeza = null;
    }
    
    // Agregar al final
    public void agregar(T valor) {
        NodoDobleCircular<T> nuevo = new NodoDobleCircular<>(valor);
        
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoDobleCircular<T> ultimo = cabeza.anterior;
            nuevo.siguiente = cabeza;
            nuevo.anterior = ultimo;
            cabeza.anterior = nuevo;
            ultimo.siguiente = nuevo;
        }
    }
    
    // Eliminar un nodo por valor
    public boolean eliminar(T valor) {
        if (cabeza == null)
            return false;
        NodoDobleCircular<T> actual = cabeza;
        
        do {
            if (actual.dato == valor) {
                if (actual == cabeza &&
                actual.siguiente == cabeza) {
                // Un solo nodo
                cabeza = null;

                } else {
                    
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    
                    if (actual == cabeza){
                        cabeza = actual.siguiente;
                    }
                }
            return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }
    
    // Mostrar hacia adelante
    public void mostrarAdelante() {
        
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        
        NodoDobleCircular<T> actual = cabeza;
        
        do {
            System.out.print(actual.dato +
            " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(vuelve al inicio)");
    }
    
    // Mostrar hacia atrás
    public void mostrarAtras() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoDobleCircular<T> actual =
        cabeza.anterior;

        do {
            System.out.print(actual.dato +
            " <-> ");
            actual = actual.anterior;
        } while (actual != cabeza.anterior);
        System.out.println("(vuelve al final)");
    }
    
    // Tamaño
    public int tamaño() {
        if (cabeza == null)
            return 0;
        int contador = 0;
        NodoDobleCircular<T> actual = cabeza;
        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return contador;
    }

}

