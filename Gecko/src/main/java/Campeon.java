/**
 * Clase en fase de desarrollo, no se ha creado el scrapeo de las entidades de esta clase.
 *
 * @author Ángel Castro Merino
 */
public class Campeon extends Enemigos {
    private String color;
    private Objeto recompensa;

    public Campeon(int id, String icono, String nombre, int vida, String descripcion, String color, Objeto recompensa) {
        super(id, icono, nombre, vida, descripcion);
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