import java.util.ArrayList;
import java.util.List;

public class FormatObjectsToList {
    List<String[]> formated_personajes_list = new ArrayList<>();
    List<String[]> formated_objetos_list = new ArrayList<>();
    List<String[]> formated_monstruos_list = new ArrayList<>();

    public void FormatPersonajeToList(List<Personaje> elements) {
        formated_personajes_list.add(elements.get(0).toString().split("-")[0].split(","));
        elements.forEach(element -> {
            formated_personajes_list.add(element.toString().split("-")[1].split(","));
        });
    }

    public void FormatObjectToList(List<Objeto> elements) {
        formated_objetos_list.add(elements.get(0).toString().split("-")[0].split(","));
        elements.forEach(element -> {
            formated_objetos_list.add(element.toString().split("-")[1].split(","));
        });
    }

    public void FormatMounstruoToList(List<Enemigo> elements) {
        formated_monstruos_list.add(elements.get(0).toString().split("-")[0].split(","));
        elements.forEach(element -> {
            formated_monstruos_list.add(element.toString().split("-")[1].split(","));
        });
    }
}
