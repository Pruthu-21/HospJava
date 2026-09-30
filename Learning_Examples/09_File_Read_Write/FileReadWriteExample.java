import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadWriteExample {

    public static void main(String[] args) {

        String fileName = "example.txt";

        // =========================
        // WRITE TO FILE
        // =========================

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(fileName))) {

            writer.println("Patient: Rahul");
            writer.println("Doctor: Dr. Patel");

            System.out.println("Data written to file.");

        } catch (IOException e) {

            System.out.println("Write error: " + e.getMessage());
        }

        // =========================
        // READ FROM FILE
        // =========================

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(fileName))) {

            String line;

            System.out.println("\nReading file:");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println("Read error: " + e.getMessage());
        }
    }
}
