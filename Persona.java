public abstract class Persona {
    private String nombre;
    private String cedula;

    public Persona(String nombre, String cedula) {
        setNombre(nombre);
        setCedula(cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = "Sin Nombre";
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula != null && !cedula.trim().isEmpty()) {
            this.cedula = cedula.trim();
        } else {
            this.cedula = "Sin Cédula";
        }
    }

    // Método abstracto para reforzar la abstracción en POO
    public abstract String obtenerInformacion();
}