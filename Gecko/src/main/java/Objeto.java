import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Objeto {
    private int id;
    private String icono;
    private String nombre;
    private String descripcion;
    private enum tipo { RECOLECTABLE,TRINKET,CARTA,PILDORA,PASIVO,ACTIVO }

    public Objeto(int id,List<WebElement> atributos) {
        this.id = id;
        icono = atributos.get(1).findElement(By.tagName("img")).getAttribute("src");
        nombre = atributos.get(2).getText();
        descripcion = atributos.get(3).getText();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "id=" + id +
                ", icono='" + icono + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}