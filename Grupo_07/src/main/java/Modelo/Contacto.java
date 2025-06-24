package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
/**
 * Clase Contacto. Representa una entidad del sistema.
 */
public abstract class Contacto {

    private String nombre;
    private String telefono;
    private String email;
    private String pais;
    private final String id;
    private ListaDobleCircular<Foto> fotos = new ListaDobleCircular<>();
    private ListaDobleCircular<Contacto> asociados = new ListaDobleCircular<>();

    public Contacto(String id, String nombre, String telefono, String email, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.pais = pais;
    }

    // Genera un ID aleatorio de 6 dígitos
    public static String generarId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    // Getters y Setters
/**
 * Método getId. Implementa una operación específica.
 */
    public String getId() {
        return id;
    }

/**
 * Método getNombre. Implementa una operación específica.
 */
    public String getNombre() {
        return nombre;
    }

/**
 * Método setNombre. Implementa una operación específica.
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/**
 * Método getTelefono. Implementa una operación específica.
 */
    public String getTelefono() {
        return telefono;
    }

/**
 * Método setTelefono. Implementa una operación específica.
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

/**
 * Método getEmail. Implementa una operación específica.
 */
    public String getEmail() {
        return email;
    }

/**
 * Método setEmail. Implementa una operación específica.
 */
    public void setEmail(String email) {
        this.email = email;
    }

/**
 * Método getPais. Implementa una operación específica.
 */
    public String getPais() {
        return pais;
    }

/**
 * Método setPais. Implementa una operación específica.
 */
    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
/**
 * Método toString. Implementa una operación específica.
 */
    public String toString() {
        return "Contacto{"
                + "id='" + id + '\''
                + ", nombre='" + nombre + '\''
                + ", telefono='" + telefono + '\''
                + ", email='" + email + '\''
                + ", pais='" + pais + '\''
                + '}';
    }

    @Override
/**
 * Método equals. Implementa una operación específica.
 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) obj;
        return this.id.equals(other.id);
    }

    @Override
/**
 * Método hashCode. Implementa una operación específica.
 */
    public int hashCode() {
        return id.hashCode();
    }

    public static ListaDobleCircular<Contacto> cargarContactos() {
        ListaDobleCircular<Contacto> contactos = new ListaDobleCircular<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("recursos/usuarios.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);
                String[] p = linea.split(",");
                if (p.length == 8) {
                    if (p[0].equals("persona")) {
                        PersonaNatural persona = new PersonaNatural(p[1], p[2], p[3], p[4], p[6], p[7],p[5]);
                        contactos.agregar(persona);
                    } else {
                        Empresa empresa = new Empresa(p[1], p[2], p[3], p[4], p[5], p[6], p[7]);
                        contactos.agregar(empresa);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("no se pudo cargar la informacion de los residentes");
            ex.printStackTrace();
        }
        return contactos;
    }

    public static void guardarContactosEnArchivo(ListaDobleCircular<Contacto> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("recursos/usuarios.txt"))) {
            if (lista.estaVacia()) {
                return;
            }

            NodoDobleCircular<Contacto> actual = lista.cabeza;
            do {
                Contacto c = actual.dato;
                if (c instanceof PersonaNatural) {
                    PersonaNatural p = (PersonaNatural) c;
                    bw.write("persona,"+ p.getId() + "," + p.getNombre() + "," + p.getApellido() + "," + p.getTelefono() + "," + p.getFechaNacimiento() + "," + p.getEmail() + "," + p.getPais());
                } else if (c instanceof Empresa) {
                    Empresa e = (Empresa) c;
                    bw.write("empresa," + e.getId() + "," + e.getNombre() + "," + e.getTelefono() + "," + e.getEmail() + "," + e.getPais() + "," + e.getRubro() + "," + e.getDireccion());
                }
                bw.newLine();
                actual = actual.siguiente;
            } while (actual != lista.cabeza);
        } catch (IOException e) {
            System.out.println("Error al guardar contactos en el archivo: " + e.getMessage());
        }
    }

    // Métodos públicos para acceder a las fotos
/**
 * Método getFotos. Implementa una operación específica.
 */
    public ListaDobleCircular<Foto> getFotos() {
        return fotos;
    }

/**
 * Método agregarFoto. Implementa una operación específica.
 */
    public void agregarFoto(Foto foto) {
        fotos.agregar(foto);
    }

/**
 * Método eliminarFoto. Implementa una operación específica.
 */
    public void eliminarFoto(Foto foto) {
        fotos.eliminar(foto);
    }

/**
 * Método limpiarFotos. Implementa una operación específica.
 */
    public void limpiarFotos() {
        fotos = new ListaDobleCircular<>();
    }
    
    public static void guardarFotosEnArchivo(ListaDobleCircular<Contacto> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("recursos/imagenes.txt"))) {
            if (lista.estaVacia()) {
                return;
            }

            NodoDobleCircular<Contacto> actual = lista.cabeza;

            do {
                Contacto contacto = actual.dato;
                ListaDobleCircular<Foto> fotos = contacto.getFotos();

                if (!fotos.estaVacia()) {
                    NodoDobleCircular<Foto> nodoFoto = fotos.cabeza;
                    do {
                        Foto foto = nodoFoto.dato;
                        String linea = contacto.getId() + "," + foto.getRuta() + "," + foto.getFechaCreacion();
                        bw.write(linea);
                        bw.newLine();
                        nodoFoto = nodoFoto.siguiente;
                    } while (nodoFoto != fotos.cabeza);
                }

                actual = actual.siguiente;
            } while (actual != lista.cabeza);

        } catch (IOException e) {
            System.out.println("Error al guardar fotos: " + e.getMessage());
        }
    }
    
    public static void cargarFotos(ListaDobleCircular<Contacto> contactos) {
        try (BufferedReader bf = new BufferedReader(new FileReader("recursos/imagenes.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] p = linea.split(",");
                if (p.length == 3) {
                    String idContacto = p[0];
                    String ruta = p[1];
                    LocalDate fecha = LocalDate.parse(p[2]);

                    Foto foto = new Foto(ruta, fecha);

                    // Buscar el contacto por ID y agregar la foto
                    NodoDobleCircular<Contacto> actual = contactos.cabeza;
                    if (actual != null) {
                        do {
                            if (actual.dato.getId().equals(idContacto)) {
                                actual.dato.agregarFoto(foto);
                                System.out.println("Foto cargada para ID " + idContacto + ": " + foto.getRuta());
                                break;
                            }
                            actual = actual.siguiente;
                        } while (actual != contactos.cabeza);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar fotos: " + e.getMessage());
        }
    }
    
/**
 * Método agregarContactoAsociado. Implementa una operación específica.
 */
    public void agregarContactoAsociado(Contacto c) {
        asociados.agregar(c);
    }

/**
 * Método getContactosAsociados. Implementa una operación específica.
 */
    public ListaDobleCircular<Contacto> getContactosAsociados() {
        return asociados;
    }
    
    
    public static void cargarContactosAsociados(ListaDobleCircular<Contacto> listaContactos) {
        try (BufferedReader br = new BufferedReader(new FileReader("recursos/usuariosAsociados.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String idDueño = partes[0];
                    String idAsociado = partes[1];

                    Contacto dueño = buscarPorId(listaContactos, idDueño);
                    Contacto asociado = buscarPorId(listaContactos, idAsociado);

                    if (dueño != null && asociado != null) {
                        dueño.agregarContactoAsociado(asociado);
                        System.out.println("El Contacto: " + asociado.getNombre() + " esta asociado al Contacto " + dueño.getNombre());
                    } else {
                        System.out.println("Asociación fallida: No se encontró algún contacto para IDs: " + idDueño + ", " + idAsociado);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo archivo de asociados: " + e.getMessage());
        }
    }
    
    public static Contacto buscarPorId(ListaDobleCircular<Contacto> lista, String id) {
        if (lista.estaVacia()) {
            return null;
        }
        NodoDobleCircular<Contacto> actual = lista.cabeza;
        do {
            if (actual.dato.getId().equals(id)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        } while (actual != lista.cabeza);
        return null;
    }
}
