
package Modelo;

/**
 *
 * @author Usuario
 */
/**
 * Clase ArrayList. Representa una entidad del sistema.
 */
public class ArrayList<E> implements Iterable<E>{
    private E[] elementos;
    private int capacidad;
    private int size;
    
    @SuppressWarnings("unchecked")
    public ArrayList(int capacidadInicial){
        this.capacidad = capacidadInicial;
        this.elementos = (E[]) new Object[capacidadInicial];
        this.size = 0;
    }

/**
 * Método addFirst. Implementa una operación específica.
 */
    public void addFirst(E elemento){
        if (size == capacidad) {
            expandirCapacidad();
        }
        for (int i = size -1 ; i >= 0; i--) {
            elementos[i+1] = elementos[i];
        }
        elementos[0] = elemento;
        size++;
    }

/**
 * Método addLast. Implementa una operación específica.
 */
    public void addLast(E elemento) {
        if (size == capacidad) {
            expandirCapacidad();
        }
        elementos[size++] = elemento;
    }

/**
 * Método imprimir. Implementa una operación específica.
 */
    public void imprimir(){
        for (int i = 0 ; i < size; i++) {
            System.out.print(elementos[i]+ " ");
        }
        System.out.println();
    }

/**
 * Método get. Implementa una operación específica.
 */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return elementos[index];
    }

/**
 * Método set. Implementa una operación específica.
 */
    public void set(int index, E elemento) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        elementos[index] = elemento;
    }

/**
 * Método size. Implementa una operación específica.
 */
    public int size() {
        return size;
    }

/**
 * Método clear. Implementa una operación específica.
 */
    public void clear() {
        size = 0;
    }

    @SuppressWarnings("unchecked")
/**
 * Método expandirCapacidad. Implementa una operación específica.
 */
    private void expandirCapacidad(){
        capacidad = capacidad * 2 ;
        E[] nuevoArreglo = (E[]) new Object[capacidad];
        for (int i = 0; i < size; i++) {
            nuevoArreglo[i] = elementos[i];
        }
        elementos = nuevoArreglo;
    }
    
    @Override
    public java.util.Iterator<E> iterator() {
        return new java.util.Iterator<E>() {
            private int indice = 0;

            @Override
/**
 * Método hasNext. Implementa una operación específica.
 */
            public boolean hasNext() {
                return indice < size;
            }

            @Override
/**
 * Método next. Implementa una operación específica.
 */
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                return elementos[indice++];
            }
        };
    }
}