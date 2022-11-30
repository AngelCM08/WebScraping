public class Campeon extends Monstruo{
    private String color;
    private Objeto recompensa;

    public Campeon(String icono, String nombre, int vida, String descripcion, String color, Objeto recompensa) {
        super(icono, nombre, vida, descripcion);
        this.color = color;
        this.recompensa = recompensa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Objeto getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Objeto recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Campeon{" +
                "color='" + color + '\'' +
                ", recompensa=" + recompensa +
                '}';
    }
}