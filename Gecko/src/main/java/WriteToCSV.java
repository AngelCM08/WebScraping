import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;

/**
 * Clase con la que se formatea a XML.
 *
 * @author Ángel Castro Merino
 */
public class WriteToCSV {
    /**
     * Función que formatea los objetos de las clases principales a XML.
     *
     * @param lines Lista de elementos que deben formatearse.
     * @param path  Ruta al archivo en el cual se van a almacenar los datos.
     */
    static public void writeAllLines(List<String[]> lines, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeAll(lines);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}