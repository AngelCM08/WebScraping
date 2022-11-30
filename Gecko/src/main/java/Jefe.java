public class Jefe extends Enemigo{
    private String ataques;
    private String habilidades;

    public Jefe(String icono, String nombre, int vida, String descripcion, String ataques, String habilidades) {
        super(icono, nombre, vida, descripcion);
        this.ataques = ataques;
        this.habilidades = habilidades;
    }

    public String getAtaques() {
        return ataques;
    }

    public void setAtaques(String ataques) {
        this.ataques = ataques;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "icono='" + super.getIcono() + '\'' +
                ", nombre='" + super.getNombre() + '\'' +
                ", vida=" + super.getVida() +
                ", descripcion='" + super.getDescripcion() + '\'' +
                ", ataques='" + ataques + '\'' +
                ", habilidades='" + habilidades + '\'' +
                '}';
    }
}