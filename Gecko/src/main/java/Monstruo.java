import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Clase que almacena la entidad del UML Monstruo.
 *
 * @author Ángel Castro Merino
 */
public class Monstruo extends Enemigos {

    /**
     * Constrctor simple de la Clase.
     */
    public Monstruo(){}

    /**
     * Constructor utilizado por la clase Enemigos para crear
     * todos los objetos Monstruo encontrados en la página web.
     *
     * @param id        Identificador del objeto.
     * @param atributos Lista con el resto de atributos de la clase recogidos en la web.
     */
    public Monstruo(int id, List<WebElement> atributos) {
        super(id,
                atributos.get(0).findElement(By.tagName("img")).getAttribute("src"), //icono
                AskName(atributos.get(0)),  //nombre
                AskVida(atributos.get(1).getText()),  //vida
                atributos.get(2).getText()); //descripción
    }

    /**
     * Función que permite formatear el valor recogido como vida,
     * en el caso de que el valor no se pueda transformar a un entero
     * significa que el monstruo tiene una vida infinita, por lo que
     * se le asigna el valor 99999, haciendo referencia a que es inmortal
     * puesto que es un valor absurdo.
     *
     * @param atributoVida  Cadena de texto recogida en la web que se debe formatear.
     * @return              Parametro recibido formateado.
     */
    private static int AskVida(String atributoVida) {
        int NumVida;
        try{
            NumVida = Integer.parseInt(atributoVida);
        }catch (NumberFormatException e){
            NumVida = 99999;
        }
        return NumVida;
    }

    /**
     * Función que permite obtener el nombre del nombre del monstruo de
     * las dos maneras posibles en las que están creadas dentro de la web.
     *
     * @param atributoName  Cadena de texto recogida en la web.
     * @return              Cadena de texto encontrada finalmente.
     */
    private static String AskName(WebElement atributoName) {
        String name;
        try{
            name = atributoName.findElements(By.tagName("a")).get(1).getText();
        }catch (IndexOutOfBoundsException e){
            name = atributoName.findElement(By.tagName("span")).getText();
        }
        return name;
    }

    /**
     * Función que devuelve una cadena de texto con los nombres de los atributos y los valores
     * de la clase en un formato específico para evitar errores y pérdidas de información.
     *
     * @return Cadena de texto con los nombres de los atributos y sus valores.
     */
    @Override
    public String toString() {
        return "id-icono-nombre-vida-descripcion---" +
                id + "--" + icono + "--" + nombre + "--" + vida + "--" + descripcion;
    }
}