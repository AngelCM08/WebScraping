import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

public class WriteToCSV {
    public void writeAllLines(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        }
        //return readFile(path);
    }
}

