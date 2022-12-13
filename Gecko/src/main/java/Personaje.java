import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena la entidad del UML Personaje.
 *
 * @author Ángel Castro Merino
 */
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

    /**
     * Constrctor simple de la Clase necesario para el formateado a XML.
     */
    public Personaje(){}

    /**
     * Constructor utilizado por la clase Personajes para crear
     * todos los objetos Personaje encontrados en la página web.
     * Cabe destacar que se filtran algunos de los atributos utilizando
     * una lista auxiliar para obtener información más limpia.
     *
     * @param id        Identificador del objeto.
     * @param atributos Lista con el resto de atributos de la clase recogidos en la web.
     */
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

    /**
     * Devuelve el atributo id de la clase.
     *
     * @return Atributo id de la clase.
     */
    @XmlElement(name="Id")
    public int getId() {
        return id;
    }

    /**
     * Devuelve el atributo icono de la clase.
     *
     * @return Atributo icono de la clase.
     */
    @XmlElement(name="Icono")
    public String getIcono() {
        return icono;
    }

    /**
     * Devuelve el atributo nombre de la clase.
     *
     * @return Atributo nombre de la clase.
     */
    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el atributo vida de la clase.
     *
     * @return Atributo vida de la clase.
     */
    @XmlElement(name="Vida")
    public int getVida() {
        return vida;
    }

    /**
     * Devuelve el atributo daño de la clase.
     *
     * @return Atributo daño de la clase.
     */
    @XmlElement(name="Daño")
    public String getDaño() {
        return daño;
    }

    /**
     * Devuelve el atributo cadencia de la clase.
     *
     * @return Atributo cadencia de la clase.
     */
    @XmlElement(name="Cadencia")
    public String getCadencia() {
        return cadencia;
    }

    /**
     * Devuelve el atributo vel_proyectil de la clase.
     *
     * @return Atributo vel_proyectil de la clase.
     */
    @XmlElement(name="Vel_Proyectil")
    public String getVel_proyectil() {
        return vel_proyectil;
    }

    /**
     * Devuelve el atributo rango de la clase.
     *
     * @return Atributo rango de la clase.
     */
    @XmlElement(name="Rango")
    public String getRango() {
        return rango;
    }

    /**
     * Devuelve el atributo velocidad de la clase.
     *
     * @return Atributo velocidad de la clase.
     */
    @XmlElement(name="Velocidad")
    public String getVelocidad() {
        return velocidad;
    }

    /**
     * Devuelve el atributo suerte de la clase.
     *
     * @return Atributo suerte de la clase.
     */
    @XmlElement(name="Suerte")
    public String getSuerte() {
        return suerte;
    }

    /**
     * Función que devuelve una cadena de texto con los nombres de los atributos y los valores
     * de la clase en un formato específico para evitar errores y pérdidas de información.
     *
     * @return Cadena de texto con los nombres de los atributos y sus valores.
     */
    @Override
    public String toString() {
        return "id-icono-nombre-vida-daño-cadencia-vel_proyectil-rango-velocidad-suerte---" +
                id + "--" + icono + "--" + nombre + "--" + vida + "--" + daño + "--" + cadencia +
                "--" + vel_proyectil + "--" + rango + "--" + velocidad + "--" + suerte ;
    }
}