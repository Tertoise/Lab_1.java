package Repository;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Repository_Reader {
    public JSONArray read() {

        //блок для читання даних з файлу
        JSONParser jsonParser = new JSONParser();
        JSONArray read_text;

        try (FileReader reader = new FileReader("Result.json")) {
            read_text = (JSONArray) jsonParser.parse(reader);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return read_text;
    }

}
