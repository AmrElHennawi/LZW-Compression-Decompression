import java.util.*;

public class LZW {

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // System.out.print("Enter the string to compress: ");
        // String str = in.nextLine();
        // System.out.println("Compressed Output: " + compression(str));
    }

    public static ArrayList<Integer> compression(String plainText) {
        Map<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> compressedOutput = new ArrayList<>();
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

        if (!subText.equals("")) {
            compressedOutput.add(dictionary.get(subText));
        }

        return compressedOutput;
    }

    public static String Decompression(ArrayList<Integer> encodedData) {
        Map<Integer, Character> dictionary = new HashMap<>();

        for (int i = 0; i < 128; i++) {
            dictionary.put(i, (char) i);
        }

        // dummy return
        return "";
    }
}