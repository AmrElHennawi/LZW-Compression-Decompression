import java.io.IOException;
import java.util.*;

public class LZW {

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            String option = System.console().readLine();
            if (option.equals("1"))
                compressionOption();
            // else if (option.equals("2"))
            // decompressionOption();
            else if (option.equals("3")) {
                System.out.println("Thanks for using our LZW Algorithms!");
                System.exit(0);
            } else
                System.out.println("Invalid option. Please choose 1, 2, or 3 :)");
        }
    }

    public static void printMainMenu() {
        System.out.println("LZW Compression and Decompression Menu :)");
        System.out.println("1. Compression");
        System.out.println("2. Decompression");
        System.out.println("3. exit.");
        System.out.print("Choose an option (1, 2, or 3): ");
    }

    public static void compression(String inputFileName, String outputFileName) {
        Map<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> compressedOutput = new ArrayList<>();
        String plainText = LZWFileHandler.readTxtFromFile(inputFileName);
        int dictSize = 128;
        String subText = "";

        for (int i = 0; i < dictSize; i++) {
            dictionary.put(String.valueOf((char) i), i);
        }

        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            String subTextPlusCurrent = subText + currentChar;

            if (dictionary.containsKey(subTextPlusCurrent)) {
                subText = subTextPlusCurrent;
            } else {
                compressedOutput.add(dictionary.get(subText));
                dictionary.put(subTextPlusCurrent, dictSize++);
                subText = String.valueOf(currentChar);
            }
        }

        LZWFileHandler.writeCompressedFile(outputFileName, compressedOutput);
        ;
    }

    public static String decode(ArrayList<Integer> encodedData) {
        Map<Integer, String> dictionary = new HashMap<>();
        StringBuilder plainText = new StringBuilder();

        final int initialDictionaryEnd = 128;

        for (int i = 0; i < initialDictionaryEnd; i++) {
            dictionary.put(i, String.valueOf((char) i));
        }
        // if not empty add the first char to the output stream
        if (!encodedData.isEmpty()) {
            plainText.append(dictionary.get(encodedData.get(0)));
        }

        int dictionaryCounter = initialDictionaryEnd;
        // for the rest of character
        int size = encodedData.size();
        for (int i = 1; i < size; i++) {
            if (dictionary.containsKey(encodedData.get(i))) {
                // add to output stream
                plainText.append(dictionary.get(encodedData.get(i)));

                // add to dictionary
                // all symbol from previous step + first symbol from current step
                String newString = dictionary.get(encodedData.get(i - 1))
                        + dictionary.get(encodedData.get(i)).charAt(0);
                dictionary.put(dictionaryCounter, newString);
                dictionaryCounter++;
            } else {
                // symbols in previous step + first symbol in previous step
                String newString = dictionary.get(encodedData.get(i - 1))
                        + dictionary.get(encodedData.get(i - 1)).charAt(0);
                dictionary.put(dictionaryCounter, newString);
                dictionaryCounter++;

                plainText.append(dictionary.get(encodedData.get(i)));
            }
        }

        return plainText.toString();
    }

    public static void compressionOption() {

        System.out.print("Enter the input file name: ");
        String inputFileName = System.console().readLine();

        System.out.print("Enter the output file name: ");
        String outputFileName = System.console().readLine();
        compression(inputFileName, outputFileName);
        System.out.println("Compression complete. Compressed data saved to " + outputFileName);
    }

}