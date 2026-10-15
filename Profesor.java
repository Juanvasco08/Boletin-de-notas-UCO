import java.util.Scanner;

public class Profesor extends Persona {
    private String materia;

    public Profesor(String nombre, String cedula, String materia) {
        super(nombre, cedula);
        setMateria(materia);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia != null && !materia.trim().isEmpty()) {
            this.materia = materia.trim();
        } else {
            this.materia = "Sin Asignar";
        }
    }

    // Implementación del método abstracto de Persona (Polimorfismo / Abstracción)
    @Override
    public String obtenerInformacion() {
        return "Docente: " + getNombre() + " | C.C.: " + getCedula() + " | Materia: " + materia;
    }

    public void registrarNotasEstudiante(Estudiante estudiante, Scanner scanner) {
        System.out.print("\n¿Cuántas notas ingresará para el estudiante?: ");
        
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️ Debe ingresar un número entero válido: ");
            scanner.next();
        }
        int cantidadNotas = scanner.nextInt();

        for (int i = 1; i <= cantidadNotas; i++) {
            double nota;
            while (true) {
                System.out.print("Ingrese la nota " + i + " (de 0.0 a 5.0): ");
                if (scanner.hasNextDouble()) {
                    nota = scanner.nextDouble();
                    if (estudiante.agregarNota(nota)) {
                        break;
                    }
                } else {
                    scanner.next(); // Limpiar entrada no numérica
                }
                System.out.println("⚠️ Nota inválida. Debe estar entre 0.0 y 5.0.");
            }
        }
        System.out.println("-> Notas registradas correctamente por el docente " + getNombre() + ".");
    }
}