/**
 * Carrera clase de nodo Padre.
 */
public class Carrera {

    private String nombreCarrera;
    private Carrera siguiente;
    private Estudiante listaEstudiantes;

    /**
     * Constructor con nombre de carrera.
     * @param carrera
     */
    public Carrera(String carrera) {
        this.nombreCarrera = carrera;
        this.siguiente = null;
        this.listaEstudiantes = null;
    }

    /**
     * Constructor vacio.
     */
    public Carrera() {
        this.siguiente = null;
        this.listaEstudiantes = null;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Carrera getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Carrera siguiente) {
        this.siguiente = siguiente;
    }

    public Estudiante getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Estudiante abajo) {
        this.listaEstudiantes = abajo;
    }

}