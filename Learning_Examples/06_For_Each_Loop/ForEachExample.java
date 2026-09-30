import java.util.ArrayList;

public class ForEachExample {

    public static void main(String[] args) {

        ArrayList<String> patients = new ArrayList<>();

        patients.add("Rahul");
        patients.add("Amit");
        patients.add("Priya");

        /*
         * Syntax:
         *
         * for (DataType variable : collection) {
         *     code
         * }
         *
         * It means:
         * Take each item from the collection,
         * one by one.
         */

        for (String patient : patients) {

            System.out.println(patient);
        }
    }
}
