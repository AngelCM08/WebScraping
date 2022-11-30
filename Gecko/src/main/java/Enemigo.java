public class Enemigo {
    private String icono;
    private String nombre;
    private int vida;
    private String descripcion;

    public Enemigo(String icono, String nombre, int vida, String descripcion) {
        this.icono = icono;
        this.nombre = nombre;
        this.vida = vida;
        this.descripcion = descripcion;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Enemigo{" +
                "icono='" + icono + '\'' +
                ", nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
