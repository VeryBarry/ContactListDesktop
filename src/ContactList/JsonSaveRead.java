package ContactList;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by VeryBarry on 9/27/16.
 */
public class JsonSaveRead {
    public static void main(String[] args) throws IOException {


        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(p);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();

        FileReader fr = new FileReader(f);
        int fileSize = (int) f.length();
        char[] contents = new char[fileSize];
        fr.read(contents, 0, fileSize);
        JsonParser parser = new JsonParser();
        Contact c = parser.parse(contents, Contact.class);
        System.out.println(c);


    }
}
