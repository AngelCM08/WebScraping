import java.util.List;
import java.util.Objects;

public class FormatObjectsToList {
    List<String[]> formated_objects_list;

    public void FormatObjectToList(List<Object> elements) {
        formated_objects_list.add(elements.get(0).toString().split("-")[0].split(","));
        elements.forEach(element -> {
            formated_objects_list.add(element.toString().split("-")[1].split(","));
        });
    }
}
