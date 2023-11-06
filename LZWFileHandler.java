import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LZWFileHandler {

    public static String readTxtFromFile(String inputFileName) {
        String output = "";
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                output += line + '\n';
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void writeCompressedFile(String path, ArrayList<Integer> encodedData) {
        try (PrintWriter outputFile = new PrintWriter(path)) {
            for (Integer tag : encodedData) {
                outputFile.println(tag);
                outputFile.flush();
            }
        } catch (IOException e) {
            System.out.println("Error while writing to the file: " + e.getMessage());
        }

    }
}
