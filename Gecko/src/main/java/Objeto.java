import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Objeto {
    private int id;
    private String icono;
    private String nombre;
    private String descripcion;

    public Objeto(){}

    public Objeto(int id,List<WebElement> atributos) {
        this.id = id;
        icono = atributos.get(1).findElement(By.tagName("img")).getAttribute("src");
        nombre = atributos.get(2).getText();
        descripcion = atributos.get(3).getText();
    }

    @XmlElement(name="Id")
    public int getId() {
        return id;
    }

    @XmlElement(name="Icono")
    public String getIcono() {
        return icono;
    }

    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name="Descripción")
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "id-icono-nombre-descripcion---" +
                id + "--" + icono + "--" + nombre + "--" + descripcion;
    }
}