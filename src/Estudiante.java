/**
 * Estudiante clase de nodo hijo.
 */
public class Estudiante {
    private String nombre;
    private String carnet;
    private int semestre;
    private Estudiante sigEstudiante;

    /**
     * Constructor de Estudiante con llenado de propiedades.
     * @param nombre Nombre del estudiante.
     * @param carnet Carnet  del estudiante.
     * @param semestre Semestre del estudiante.
     */
    public Estudiante(String nombre, String carnet, int semestre) {
        this.nombre = nombre;
        this.carnet=carnet;
        this.semestre=semestre;
        this.sigEstudiante=null;
    }

    public Estudiante() {
        this.sigEstudiante=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Estudiante getSigEstudiante() {
        return sigEstudiante;
    }

    public void setSigEstudiante(Estudiante nuevoEstudiante) {
        this.sigEstudiante = nuevoEstudiante;
    }
    
}
