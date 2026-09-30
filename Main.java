import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(1, "John Doe", "Computer Science");

        System.out.println("Student ID: " + student1.getId()); // getId Function in Student.java 
        System.out.println("Student Name: " + student1.getName());
        System.out.println("Student Course: " + student1.getCourse());

        // Modifying the student's name and course using setter methods

        student1.setName("Jane Doe"); // setName Function in Student.java
        student1.setCourse("Mathematics");

        System.out.println("Updated Student Name: " + student1.getName());
        System.out.println("Updated Student Course: " + student1.getCourse());
    }
}
