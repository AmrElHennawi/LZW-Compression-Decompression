import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileHandler {

    public static String readFile(String path) throws IOException {
        String output = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                output += line + '\n';
            }
        }
        return output;
    }

    public static void writeFile(String path, String data) throws IOException {
        try (FileWriter destFile = new FileWriter(path)) {
            destFile.write(data);
        }

    }
}
