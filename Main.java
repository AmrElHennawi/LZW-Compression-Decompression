import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true){
            printMainMenu();
            Scanner myReader = new Scanner(System.in);
            int choice = myReader.nextInt();

            System.out.println("Please enter the filename");
            String filePath = myReader.next();
            File file = new File(filePath);

            System.out.println("Please enter the destination filename");
            String destFilePath = myReader.next();

            myReader.close();

            if (choice == 1){
                LZW.compressFile(filePath, destFilePath);
            } else if (choice == 2){
                LZW.decompressFile(filePath, destFilePath);
            } else if (choice == 3) {
                System.out.println("Thank you for using our program\n");
                return;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

        public static void printMainMenu() {
        System.out.println("LZW Compression and Decompression Menu :)");
        System.out.println("1. Compression");
        System.out.println("2. Decompression");
        System.out.println("3. exit.");
        System.out.print("Choose an option (1, 2, or 3): ");
    }
}
