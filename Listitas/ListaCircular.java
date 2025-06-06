package Listitas;

public class ListaCircular<T> implements MiLista<T> {
    private Nodo ultimo;
    private int tamaño;
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) {
            this.dato=dato;
            this.siguiente=this;
        }
    }
    
    public ListaCircular() {
        this.ultimo=null;
        this.tamaño=0;
    }
    @Override
    public void agregar(T elemento) {
        Nodo nuevo=new Nodo(elemento);
        if (ultimo==null) {
            ultimo=nuevo;
        } else {
            nuevo.siguiente=ultimo.siguiente;
            ultimo.siguiente=nuevo;
            ultimo=nuevo;
        }
        tamaño++;
    }
    @Override
    public boolean eliminar(int indice) {
        if (tamaño==0||indice<0||indice>=tamaño)return false;
        Nodo actual= ultimo.siguiente;
        Nodo anterior=ultimo;
        for (int i=0;i<indice;i++) {
            anterior=actual;
            actual=actual.siguiente;
        }
        if(actual==ultimo) {
            if(tamaño==1) {
                ultimo=null;
            } else {
                anterior.siguiente = actual.siguiente;
                ultimo = anterior;
            }
        } else {
            anterior.siguiente = actual.siguiente;
        }
        tamaño--;
        return true;
    }
    @Override
    public T obtener(int indice) {
        if (indice < 0 || indice >= tamaño) throw new IndexOutOfBoundsException();
        Nodo actual = ultimo.siguiente;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }
    @Override
    public int tamaño() {
        return tamaño;
    }
    @Override
    public void imprimir() {
        if (tamaño == 0) {
            System.out.println("Lista vacía");
            return;
        }
        Nodo actual = ultimo.siguiente;
        for (int i = 0; i < tamaño; i++) {
            System.out.println("- " + actual.dato);
            actual = actual.siguiente;
        }
    }
}

