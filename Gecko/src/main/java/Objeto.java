import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Clase que almacena la entidad del UML Personaje.
 *
 * @author Ángel Castro Merino
 */
@XmlRootElement
public class Objeto {
    private int id;
    private String icono;
    private String nombre;
    private String descripcion;

    /**
     * Constrctor simple de la Clase necesario para el formateado a XML.
     */
    public Objeto(){}

    /**
     * Constructor utilizado por la clase Objetos para crear
     * todos los objetos Objeto encontrados en la página web.
     *
     * @param id        Identificador del objeto.
     * @param atributos Lista con el resto de atributos de la clase recogidos en la web.
     */
    public Objeto(int id,List<WebElement> atributos) {
        this.id = id;
        icono = atributos.get(1).findElement(By.tagName("img")).getAttribute("src");
        nombre = atributos.get(2).getText();
        descripcion = atributos.get(3).getText();
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
     * Devuelve el atributo descripcion de la clase.
     *
     * @return Atributo descripcion de la clase.
     */
    @XmlElement(name="Descripción")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Función que devuelve una cadena de texto con los nombres de los atributos y los valores
     * de la clase en un formato específico para evitar errores y pérdidas de información.
     *
     * @return Cadena de texto con los nombres de los atributos y sus valores.
     */
    @Override
    public String toString() {
        return "id-icono-nombre-descripcion---" +
                id + "--" + icono + "--" + nombre + "--" + descripcion;
    }
}