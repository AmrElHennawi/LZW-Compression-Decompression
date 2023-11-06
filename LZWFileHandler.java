import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LZWFileHandler {

    public static ArrayList<Integer> readFile(String path) throws FileNotFoundException {
        ArrayList<Integer> encodedData = new ArrayList<Integer>();
        File file = new File(path);
        if (!file.exists()){
            throw new FileNotFoundException();
        }

        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()){
            encodedData.add(Integer.valueOf(myReader.nextLine()));
        }

        myReader.close();

        return encodedData;
    }

    // TODO
    public static void writeFile(String path, ArrayList<Integer> encodedData){
        // write an encoded data (integers) to a file separated by newlines

    }

//    public static String readTxtFromFile(String inputFileName) {
//        String output = "";
//        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                output += line + '\n';
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return output;
//    }
//
//    public static void writeCompressedFile(String path, ArrayList<Integer> encodedData) {
//        try (PrintWriter outputFile = new PrintWriter(path)) {
//            for (Integer tag : encodedData) {
//                outputFile.println(tag);
//                outputFile.flush();
//            }
//        } catch (IOException e) {
//            System.out.println("Error while writing to the file: " + e.getMessage());
//        }
//    }
}
