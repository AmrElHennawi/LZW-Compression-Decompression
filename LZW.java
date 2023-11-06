import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LZW {


    // TODO
    // takes a string of text
    // returns ArrayList containing the numbers/integers
    public static void encode(String inputFileName, String outputFileName) {
//        Map<String, Integer> dictionary = new HashMap<>();
//        ArrayList<Integer> compressedOutput = new ArrayList<>();
//        String plainText = LZWFileHandler.readTxtFromFile(inputFileName);
//        int dictSize = 128;
//        String subText = "";
//
//        for (int i = 0; i < dictSize; i++) {
//            dictionary.put(String.valueOf((char) i), i);
//        }
//
//        for (int i = 0; i < plainText.length(); i++) {
//            char currentChar = plainText.charAt(i);
//            String subTextPlusCurrent = subText + currentChar;
//
//            if (dictionary.containsKey(subTextPlusCurrent)) {
//                subText = subTextPlusCurrent;
//            } else {
//                compressedOutput.add(dictionary.get(subText));
//                dictionary.put(subTextPlusCurrent, dictSize++);
//                subText = String.valueOf(currentChar);
//            }
//        }
//
//        LZWFileHandler.writeCompressedFile(outputFileName, compressedOutput);
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

    // TODO
    public static void compressFile(String inputFileName, String outputFileName){

    }

    public static void decompressFile(String inputFileName, String outputFileName) throws IOException {
        ArrayList<Integer> encodedData = LZWFileHandler.readFile(inputFileName);
        TextFileHandler.writeFile(outputFileName, decode(encodedData));
    }

}