import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Universidad clase que implementa las multilistas.
 */
public class Universidad {
    private Carrera cabeza;
    private Carrera cola;

    /**
     * Constructor clase Universidad.
     */
    public Universidad() {

    }

    /**
     * Adiciona carrera.
     * @param nombreCarrera
     */
    public void agregarCarrera(String nombreCarrera) {
        Carrera carrera = new Carrera(nombreCarrera);

        if (esCarrerasVacia()) {
            cola = cabeza = carrera;
        } else {
            cola.setSiguiente(carrera);
            cola = carrera;
        }
    }

    /**
     * Busca la carrera por nombre sin tener encuenta mayusculas o minusculas.
     * @param nombreCarrera Nombre de la carrera a buscar.
     * @return Elemento tipo Carrera encontrada, sino se encuentra retorna <b>null</b>
     */
    public Carrera buscarCarrera(String nombreCarrera) {
        Carrera iterador = cabeza;
        try {
            while (iterador != null) {
                if (iterador.getNombreCarrera().equalsIgnoreCase(nombreCarrera)) {
                    return iterador;
                }

                iterador = iterador.getSiguiente();
            }

            System.out.println("No se encontro la carrera buscada.");
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    /**
     * Adiciona estudiante a la carrera ingresada.
     * @param nombreCarrera Carrera a la cual se adiciona el estudiante.
     * @param nombre Nombre del estudiante nuevo.
     * @param carnet Carnet del estudiante nuevo.
     * @param semestre Semestre del estudiante nuevo.
     */
    public void agregarEstudiante(String nombreCarrera, String nombre, String carnet, int semestre) {
        Carrera carrera = buscarCarrera(nombreCarrera);
        if (carrera != null) {
            Estudiante estudiantesLista = carrera.getListaEstudiantes();
            Estudiante nuevoEstudiante = new Estudiante(nombre, carnet, semestre);

            if (estudiantesLista == null) {
                carrera.setListaEstudiantes(nuevoEstudiante);
            } else {
                while (estudiantesLista.getSigEstudiante() != null) {
                    estudiantesLista = estudiantesLista.getSigEstudiante();
                }

                estudiantesLista.setSigEstudiante(nuevoEstudiante);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Carrera no existe.");
        }
    }

    /**
     * Visualiza las carreras existentes.
     */
    public void mostrarCarreras() {
        Carrera carreras = cabeza;
        String respuesta = "";
        while (carreras != null) {
            respuesta += String.format("*  %s \n ", carreras.getNombreCarrera());
            respuesta += "______________________________________________\n";
            carreras = carreras.getSiguiente();
        }

        if (respuesta.isBlank()) {
            respuesta = "No hay carreras registradas.\n";
        }

        JOptionPane.showMessageDialog(null, respuesta, "Lista de Carreras", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Visualiza la lista de todos los estudiantes con sus carreras.
     */
    public void MostrarCarrerasConEstudiantes() {
        Carrera carreras = cabeza;
        String[] columnas = { "CARRERA", "NOMBRE", "CARNET", "SEMESTRE" };
        ArrayList<FilaTabla> listaAlumnosDatos = new ArrayList<FilaTabla>();
        while (carreras != null) {
            String carrera = carreras.getNombreCarrera();
            Estudiante listaEstudiantes = carreras.getListaEstudiantes();

            while (listaEstudiantes != null) {
                listaAlumnosDatos.add(new FilaTabla(carrera, listaEstudiantes.getNombre(), listaEstudiantes.getCarnet(),
                        listaEstudiantes.getSemestre()));

                listaEstudiantes = listaEstudiantes.getSigEstudiante();
            }

            carreras = carreras.getSiguiente();
        }

        if (listaAlumnosDatos.size() < 1) {
            JOptionPane.showMessageDialog(null, "No hay carreras registradas.\n");
        } else {
            Object filas[][] = new Object[listaAlumnosDatos.size()][4];
            for (int i = 0; i < filas.length; i++) {
                filas[i][0] = listaAlumnosDatos.get(i).carrera;
                filas[i][1] = listaAlumnosDatos.get(i).nombre;
                filas[i][2] = listaAlumnosDatos.get(i).carnet;
                filas[i][3] = listaAlumnosDatos.get(i).semestre;
            }

            JTable table = new JTable(filas, columnas);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        }
    }

    /**
     * Visualiza la lista de estudiantes de una carrera especifica.
     * @param nombreCarrera Carrera a visualizar.
     */
    public void mostrarEstudiantesPorCarrera(String nombreCarrera) {
        Carrera carrera = buscarCarrera(nombreCarrera);
        if (carrera != null) {
            String[] columnas = { "NOMBRE", "CARNET", "SEMESTRE" };
            ArrayList<FilaTabla> listaAlumnosDatos = new ArrayList<FilaTabla>();

            Estudiante listaEstudiantes = carrera.getListaEstudiantes();

            while (listaEstudiantes != null) {
                listaAlumnosDatos.add(new FilaTabla("", listaEstudiantes.getNombre(), listaEstudiantes.getCarnet(),
                        listaEstudiantes.getSemestre()));

                listaEstudiantes = listaEstudiantes.getSigEstudiante();
            }

            if (listaAlumnosDatos.size() < 1) {
                JOptionPane.showMessageDialog(null, "No hay carreras registradas.\n");
            } else {
                Object filas[][] = new Object[listaAlumnosDatos.size()][3];
                for (int i = 0; i < filas.length; i++) {
                    filas[i][0] = listaAlumnosDatos.get(i).nombre;
                    filas[i][1] = listaAlumnosDatos.get(i).carnet;
                    filas[i][2] = listaAlumnosDatos.get(i).semestre;
                }

                JTable table = new JTable(filas, columnas);
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
            }

        } else {
            JOptionPane.showMessageDialog(null, "Carrera no existe.");
        }
    }

    /**
     * Valida si las carreras estan vacia.
     * 
     * @return true si es vacia y false si tiene elemento.
     */
    private boolean esCarrerasVacia() {
        return cabeza == null;
    }

    /**
     * Estructura de una fila para creacioin de visuales de tabla.
     */
    private class FilaTabla {
        String carrera;
        String nombre;
        String carnet;
        int semestre;

        /**
         * Constructor de FilaTabla.
         * @param carrera Carrera del estudiante a visualizar.
         * @param nombre Nombre del estudiante a visualizar.
         * @param carnet Carnet del estudiante a visualizar.
         * @param semestre Semestre del estudiante a visualizar.
         */
        public FilaTabla(String carrera, String nombre, String carnet, int semestre) {
            this.carrera = carrera;
            this.nombre = nombre;
            this.carnet = carnet;
            this.semestre = semestre;
        }
    }
}
