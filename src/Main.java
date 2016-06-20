import com.jsontocsv.parser.JsonFlattener;
import com.jsontocsv.writer.CSVWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        JsonFlattener parser = new JsonFlattener();
        CSVWriter writer = new CSVWriter();

        List<Map<String, String>> flatJson = parser.parseJson(jsonValue());
        writer.writeAsCSV(flatJson, "sample.csv");
    }

    static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    private static String jsonValue() throws IOException {
        String content = readFile("C:\\Users\\***\\Desktop\\***.json", StandardCharsets.UTF_8);
        return content;
    }
}
