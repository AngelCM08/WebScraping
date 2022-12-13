import java.util.ArrayList;
import java.util.List;


/**
 * Clase que permite formatear los objetos de las clases principales en listas de arrays de strings,
 * donde cada posicion del string es uno de los atributos del objeto, este formato es necesario para
 * que se puedan formatear finalmente a XML.
 *
 * @author Ángel Castro Merino
 */
public class FormatObjectsToList {
    List<String[]> formated_personajes_list = new ArrayList<>();
    List<String[]> formated_objetos_list = new ArrayList<>();
    List<String[]> formated_monstruos_list = new ArrayList<>();

    /**
     * Función que monta el formato correcto a los elementos de la lista de Personajes.
     *
     * @param elements Lista de objetos de la clase Personaje.
     */
    public void FormatPersonajeToList(List<Personaje> elements) {
        formated_personajes_list.add(elements.get(0).toString().split("---")[0].split("--"));
        elements.forEach(element -> {
            formated_personajes_list.add(element.toString().split("---")[1].split("--"));
        });
    }

    /**
     * Función que monta el formato correcto a los elementos de la lista de Objetos.
     *
     * @param elements Lista de objetos de la clase Objeto.
     */
    public void FormatObjectToList(List<Objeto> elements) {
        formated_objetos_list.add(elements.get(0).toString().split("---")[0].split("--"));
        elements.forEach(element -> {
            formated_objetos_list.add(element.toString().split("---")[1].split("--"));
        });
    }

    /**
     * Función que monta el formato correcto a los elementos de la lista de Monstruos.
     *
     * @param elements Lista de objetos de la clase Monstruo.
     */
    public void FormatMonstruoToList(List<Monstruo> elements) {
        formated_monstruos_list.add(elements.get(0).toString().split("---")[0].split("--"));
        elements.forEach(element -> {
            formated_monstruos_list.add(element.toString().split("---")[1].split("--"));
        });
    }
}
