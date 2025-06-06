package Listitas;

public interface MiLista<T> {
    void agregar(T elemento);
    boolean eliminar(int indice);
    T obtener(int indice);
    int tamaño();
    void imprimir();
}
//Muchachos aqui trate de replicar algo similar al codigo que nos puso el profesor pero con atributos que posiblemente usaremos
//Durante la elaboracion , no se si vayan a querer agregar mas
