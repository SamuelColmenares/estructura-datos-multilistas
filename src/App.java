import javax.swing.JOptionPane;

public class App {

    /**
     * Multilista de la aplicacion.
     */
    private static Universidad universidad = new Universidad();

    public static void main(String[] args) throws Exception {

        int opcionMenu = 0, dato;
        String datoStr;

        PrecargaDatos();

        // Ciclo que se mantiene mientras no se seleccione la opcion finalizar.
        do {

            // Seleccion de datos al usuario con modal.
            datoStr = JOptionPane.showInputDialog(null,
                    "Selecciona un ítem:\n\n" + 
                    "1- Adicionar Carrera\n" + 
                    "2- Mostrar Carreras\n" + 
                    "3- Mostrar Mostrar Estudiantes por carrera\n" + 
                    "4- Mostrar todos los Estudiantes\n" + 
                    "5- SALIR",
                    "MENÚ", JOptionPane.INFORMATION_MESSAGE);

            // Se valida que el dato ingresado por el usuario sea de 1 solo digito y entre 1
            // y 5 con expresiones regulares.
            if (datoStr.matches("^[12345]{1}$")) {
                dato = Integer.parseInt(datoStr);
                opcionMenu = dato;

                // Se llama al metodo de la logica.
                seleccionItem(dato);
            } else {
                // Mensaje de error en caso de seleccionar un valor de menu incorrecto.
                JOptionPane.showMessageDialog(null, "Valor no valido, sólo seleccionar entre 1 y 5.");
            }

        } while (opcionMenu != 5);
    }

    /**
     * Ejecuta la logica cuando se selecciona una opción válida.
     * 
     * @param menuItem Item del menu seleccionado.
     */
    public static void seleccionItem(int menuItem) {
        String datos = "";

        switch (menuItem) {
            case 1:
                datos = ingresarDatos("Agregar Carrera");
                if (!datos.isBlank()) {
                    universidad.agregarCarrera(datos);
                }
                break;
            case 2:
                universidad.mostrarCarreras();
                break;

            case 3:
                datos = ingresarDatos("Mostrar Estudiantes X Carrera");
                if (!datos.isBlank()) {
                    universidad.mostrarEstudiantesPorCarrera(datos);
                }
                break;

            case 4:
                universidad.MostrarCarrerasConEstudiantes();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Fin de la aplicación.");
                break;
        }
    }

    /**
     * Lee el valor ingresado por el usuario y valida si es correcto.
     * 
     * @param titulo Titulo de la ventana de captura de información.
     * @return El valor entero recibido del usuario, en caso de ser erroneo devuelve
     *         el valor menor posible de entero (MIN_VALUE).
     */
    public static String ingresarDatos(String titulo) {
        String dato = "";
        // Se lee los datos ingresados por el usuario
        String datoStr = JOptionPane.showInputDialog(null, "Ingresa Dato:", titulo, JOptionPane.INFORMATION_MESSAGE);
        // Se valida que sea in numero positivo o negativo con expresiones regulares.
        if (!datoStr.isBlank()) {
            dato = datoStr;
        } else {
            // Mensaje de error en caso de no ser dato correcto
            JOptionPane.showMessageDialog(null, "Valor no valido, debe escribir algún valor.");
        }

        return dato;
    }

    public static void PrecargaDatos() {
        universidad.agregarCarrera("Medicina");
        universidad.agregarCarrera("Diseño Grafico");
        universidad.agregarCarrera("Ingenieria");
        universidad.agregarCarrera("Arquitectura");

        // Adicion estudiantes medicina
        universidad.agregarEstudiante("Medicina", "Juan Perez", "25465", 2);
        universidad.agregarEstudiante("Medicina", "Maria Casas", "78656", 3);
        universidad.agregarEstudiante("Medicina", "Pedro Picapiedra", "12223", 5);
        universidad.agregarEstudiante("Medicina", "Jhon Solis", "98785", 8);

        // Adicion estudiantes Diseño
        universidad.agregarEstudiante("Diseño Grafico", "Jaime Daza", "3454456", 9);
        universidad.agregarEstudiante("Diseño Grafico", "Julian Castro", "23987", 2);
        universidad.agregarEstudiante("Diseño Grafico", "Mariana Lima", "123454", 4);
        universidad.agregarEstudiante("Diseño Grafico", "Kathe Cho", "987678", 2);

        // Adicion estudiantes Ingenieria
        universidad.agregarEstudiante("Ingenieria", "Miguel Campos", "123322", 6);
        universidad.agregarEstudiante("Ingenieria", "Julian Perez", "555555", 3);
        universidad.agregarEstudiante("Ingenieria", "Michel Alloy", "999944", 7);
        universidad.agregarEstudiante("Ingenieria", "Juan Castro", "25465", 1);

        // Adicion estudiantes Arquitectura
        universidad.agregarEstudiante("Arquitectura", "Sebastian Perez", "3434343", 2);
        universidad.agregarEstudiante("Arquitectura", "Aminta Cruz", "222222", 4);
        universidad.agregarEstudiante("Arquitectura", "Diego Lopez", "3333331", 8);
        universidad.agregarEstudiante("Arquitectura", "Ruth Caro", "777772", 1);
    }
}
