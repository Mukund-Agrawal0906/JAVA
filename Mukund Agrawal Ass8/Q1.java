import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int roll;
    String birthyear;

    public Student(String name, int roll, String birthyear) {
        this.name = name;
        this.roll = roll;
        this.birthyear = birthyear;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name); 
    }

    public static Comparator<Student> TitleComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            String title1 = s1.name.split(" ")[1];
            String title2 = s2.name.split(" ")[1];
            return title1.compareTo(title2);
        }
    };

    public static Comparator<Student> RollComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return Integer.compare(s1.roll, s2.roll);
        }
    };

    public static Comparator<Student> BirthyearComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.birthyear.compareTo(s2.birthyear);
        }
    };

    @Override
    public String toString() {
        return "Name: " + name + ", Roll: " + roll + ", Birthyear: " + birthyear;
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the No. of Students: ");
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name (First Name Last Name Title): ");
            String name = scanner.nextLine();
            System.out.print("Roll Number: ");
            int roll = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Birthyear: ");
            String birthyear = scanner.nextLine();

            students.add(new Student(name, roll, birthyear));
        }

        Collections.sort(students);
        System.out.println("Sorted by first name:");
        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students, Student.TitleComparator);
        System.out.println("\nSorted by title:");
        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students, Student.RollComparator);
        System.out.println("\nSorted in reverse order of roll number:");
        for (Student student : students) {
            System.out.println(student);
        }

        Collections.sort(students, Student.BirthyearComparator);
        System.out.println("\nSorted by birthyear in ascending order:");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}
