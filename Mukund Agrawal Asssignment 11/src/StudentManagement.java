import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int rollNumber;
    private double cpi;
    private int age;

    public Student(String firstName, String lastName, int rollNumber, double cpi, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNumber = rollNumber;
        this.cpi = cpi;
        this.age = age;
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public double getCPI() {
        return cpi;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                ", Roll Number: " + rollNumber +
                ", CPI: " + cpi +
                ", Age: " + age;
    }
}

public class StudentManagement {
    private static final String FILENAME = "Student.ser";

    public static void main(String[] args) {
        List<Student> students = deserializeStudents();

        int choice;
        do {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    students.add(createStudent(scanner));
                    break;
                case 2:
                    displayStudentsWithInitial(students, 'M');
                    break;
                case 3:
                    displayStudentsBelowAge(students, 18);
                    break;
                case 4:
                    serializeStudents(students);
                    System.out.println("Students serialized and saved to " + FILENAME);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void displayMenu() {
        System.out.println("Student Management Menu:");
        System.out.println("1. Add a student");
        System.out.println("2. Display students whose names start with 'M'");
        System.out.println("3. Display students below a certain age");
        System.out.println("4. Save students to file");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static Student createStudent(Scanner scanner) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter CPI: ");
        double cpi = scanner.nextDouble();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        return new Student(firstName, lastName, rollNumber, cpi, age);
    }

    private static List<Student> deserializeStudents() {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILENAME))) {
            List<Student> loadedStudents = (List<Student>) in.readObject();
            students.addAll(loadedStudents);
        } catch (IOException | ClassNotFoundException e) {
            // Handle the case when the file doesn't exist or is empty
        }
        return students;
    }

    private static void serializeStudents(List<Student> students) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            out.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayStudentsWithInitial(List<Student> students, char initial) {
        System.out.println("Students whose names start with 'M':");
        for (Student student : students) {
            if (student.getFirstName().toUpperCase().charAt(0) == initial || student.getLastName().toUpperCase().charAt(0) == initial) {
                System.out.println(student);
            }
        }
    }

    private static void displayStudentsBelowAge(List<Student> students, int ageLimit) {
        System.out.println("Students with age below 18:");
        for (Student student : students) {
            if (student.getAge() < ageLimit) {
                System.out.println(student);
            }
        }
    }
}
