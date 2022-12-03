import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Jefe extends Enemigo{
    private String ataques;

    public Jefe(int id, List<WebElement> atributos) {
        super(id,
                atributos.get(0).getAttribute("src"), //icono
                atributos.get(1).getText(),  //nombre
                Integer.parseInt(atributos.get(2).getText()),  //vida
                atributos.get(3).getText()); //descripción
        this.ataques = ataques;
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