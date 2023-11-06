import java.util.*;

public class LZW {


    public static void main(String[] args) {

    }
    public static ArrayList<Integer> compression(String plainText){
        Map<String, Integer> dictionary = new HashMap<>();
        ArrayList<Integer> compressedOutput = new ArrayList<>();

        return new ArrayList<>();
    }


    public static String Decompression(ArrayList<Integer> encodedData){
        Map<Integer, Character> dictionary = new HashMap<>();

        for (int i = 0; i < 128; i++){
            dictionary.put(i, (char) i);
        }

        // dummy return
        return "";
    }
}