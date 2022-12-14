import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Clase en fase de desarrollo, se ha intentado el scrapeo
 * de las entidades de esta clase de forma fallida puesto
 * que las páginas de la web son variadas dependiendo el
 * elemento Jefe que se quiera Scrapear.
 *
 * @author Ángel Castro Merino
 */
public class Jefe extends Enemigos {
    private String ataques;

    public Jefe(int id, List<WebElement> atributos) {
        super(id,
                atributos.get(0).getAttribute("src"), //icono
                atributos.get(1).getText(),  //nombre
                AskValueLife(atributos.get(2)),  //vida
                null); //descripción : No hay un patrón entre las páginas como para automatizar la recogida de datos...
    }

    private static int AskValueLife(WebElement vida) {
        if(vida.getText() == null) return 0;
        else return Integer.parseInt(vida.getText());
    }


    public String getAtaques() {
        return ataques;
    }

    public void setAtaques(String ataques) {
        this.ataques = ataques;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "icono='" + super.getIcono() + '\'' +
                ", nombre='" + super.getNombre() + '\'' +
                ", vida=" + super.getVida() +
                ", descripcion='" + super.getDescripcion() + '\'' +
                ", ataques='" + ataques + '\'' +
                '}';
    }
}