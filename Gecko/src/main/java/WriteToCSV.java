import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.List;

public class WriteToCSV {
    static public void writeAllLines(List<String[]> lines, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeAll(lines);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}