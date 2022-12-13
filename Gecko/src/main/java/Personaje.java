import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Personaje {
    private int id;
    private String icono;
    private String nombre;
    private int vida;
    private String daño;
    private String cadencia;
    private String vel_proyectil;
    private String rango;
    private String velocidad;
    private String suerte;

    public Personaje(){}

    public Personaje(int id, List<WebElement> atributos) {
        List<String> aux = new ArrayList<>();
        atributos.forEach(text -> aux.add(text.getText().split("\n")[0]));

        this.id = id;
        icono = atributos.get(0).findElement(By.tagName("img")).getAttribute("src");
        nombre = aux.get(1);
        vida = atributos.get(2).findElements(By.tagName("img")).size();
        daño = aux.get(3);
        cadencia = aux.get(4);
        vel_proyectil = aux.get(5);
        rango = aux.get(6);
        velocidad = aux.get(7);
        suerte = aux.get(8);
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

    @XmlElement(name="Vida")
    public int getVida() {
        return vida;
    }

    @XmlElement(name="Daño")
    public String getDaño() {
        return daño;
    }

    @XmlElement(name="Cadencia")
    public String getCadencia() {
        return cadencia;
    }

    @XmlElement(name="Vel_Proyectil")
    public String getVel_proyectil() {
        return vel_proyectil;
    }

    @XmlElement(name="Rango")
    public String getRango() {
        return rango;
    }

    @XmlElement(name="Velocidad")
    public String getVelocidad() {
        return velocidad;
    }

    @XmlElement(name="Suerte")
    public String getSuerte() {
        return suerte;
    }

    @Override
    public String toString() {
        return "id-icono-nombre-vida-daño-cadencia-vel_proyectil-rango-velocidad-suerte---" +
                id + "--" + icono + "--" + nombre + "--" + vida + "--" + daño + "--" + cadencia +
                "--" + vel_proyectil + "--" + rango + "--" + velocidad + "--" + suerte ;
    }
}