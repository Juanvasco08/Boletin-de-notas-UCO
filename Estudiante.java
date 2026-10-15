import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Estudiante extends Persona {
    public static final double NOTA_MINIMA_APROBATORIA = 3.0;
    
    private String carrera;
    private final ArrayList<Double> notas;

    public Estudiante(String nombre, String cedula, String carrera) {
        super(nombre, cedula);
        this.carrera = carrera;
        this.notas = new ArrayList<>();
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    // Retorna una lista no modificable para proteger la encapsulación
    public List<Double> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    // Validación de rango académico (0.0 a 5.0)
    public boolean agregarNota(double nota) {
        if (nota >= 0.0 && nota <= 5.0) {
            this.notas.add(nota);
            return true;
        }
        return false;
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    public boolean estaAprobado() {
        return calcularPromedio() >= NOTA_MINIMA_APROBATORIA;
    }
}