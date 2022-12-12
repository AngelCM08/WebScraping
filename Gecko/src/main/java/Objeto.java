import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Objeto {
    private int id;
    private String icono;
    private String nombre;
    private String descripcion;

    public Objeto(int id,List<WebElement> atributos) {
        this.id = id;
        icono = atributos.get(1).findElement(By.tagName("img")).getAttribute("src");
        nombre = atributos.get(2).getText();
        descripcion = atributos.get(3).getText();
    }

    @Override
    public String toString() {
        return "id-icono-nombre-descripcion---" +
                id + "--" + icono + "--" + nombre + "--" + descripcion;
    }
}