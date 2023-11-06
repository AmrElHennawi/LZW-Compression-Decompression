import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LZWFileHandler {

    public static ArrayList<Integer> readFile(String path) throws FileNotFoundException {
        ArrayList<Integer> encodedData = new ArrayList<Integer>();
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            encodedData.add(Integer.valueOf(myReader.nextLine()));
        }

        myReader.close();
        return encodedData;
    }

    public static void writeFile(String path, ArrayList<Integer> encodedData) throws FileNotFoundException {
        PrintWriter outputFile = new PrintWriter(path);
        for (Integer tag : encodedData) {
            outputFile.println(tag);
            outputFile.flush();
        }
        outputFile.close();
    }
}
