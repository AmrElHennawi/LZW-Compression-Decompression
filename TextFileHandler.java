import java.io.FileWriter;
import java.io.IOException;

public class TextFileHandler {

    // TODO
    public static String readFile(String path){
        return "";
    }

    public static void writeFile(String path, String data) throws IOException {
        try(FileWriter destFile = new FileWriter(path)){
            destFile.write(data);
        }

    }
}
