
package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    
    public static ListaDobleCircular<GestorContactos> cargarContactos(){
        ListaDobleCircular<GestorContactos> contactos = new ListaDobleCircular<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("recursos/residentes.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                String[] p = linea.split(",");
                if (p.length == 7) {
                    if(p[0]=="persona"){
                       PersonaNatural persona = new PersonaNatural(p[1],p[3],p[5],p[6],p[2],p[4]);                       
                       //contactos.agregar(new PersonaNatural(p[1],p[3],p[5],p[6],p[2],p[4])); 
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los residentes");
            ex.printStackTrace();
        }
        return contactos;
    }
}
