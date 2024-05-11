import java.util.Scanner;

class Person2 {
    int age;

    public Person2(int age) {
        this.age = age;
    }

    void eat() {
        System.out.println("Person is eating.");
    }

    void sleep() {
        System.out.println("Person is sleeping.");
    }
}

interface Driver2 {
    int driveCar();

    int driveBike();
}

interface Singer2 {
    int riyaz();

    int sing();
}

class Employee2 extends Person2 implements Driver2, Singer2 {

    public Employee2(int age) {
        super(age);
    }

    @Override
    public int driveCar() {
        return (age < 40) ? 10 : 0;
    }

    @Override
    public int driveBike() {
        return (age < 40) ? 5 : 0;
    }

    @Override
    public int riyaz() {
        return (age < 20) ? 15 : 0;
    }

    @Override
    public int sing() {
        return (age < 20) ? 15 : 0;
    }

    int officeWork() {
        return (age < 40) ? 20 : 10;
    }
}

public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of person");
        int n = scanner.nextInt();
        Employee2[] employee2s = new Employee2[n];

        for (int i = 0; i < employee2s.length; i++) {
            System.out.print("Enter age for employee " + (i + 1) + ": ");
            int age = scanner.nextInt();
            employee2s[i] = new Employee2(age);
        }

        int[] eifValues = new int[employee2s.length];
        for (int i = 0; i < employee2s.length; i++) {
            eifValues[i] = employee2s[i].driveCar() + employee2s[i].driveBike() +
                    employee2s[i].sing() + employee2s[i].officeWork();
        }
        System.out.println("BEFORE SORTING");

        for (Employee2 employee2 : employee2s) {
            System.out.println("Age: " + employee2.age + ", EIF: " +
                    (employee2.driveCar() + employee2.driveBike() +
                            employee2.sing() + employee2.officeWork()));
        }
        sort(employee2s, eifValues);

        System.out.println("AFTER SORTING");

        for (Employee2 employee2 : employee2s) {
            System.out.println("Age: " + employee2.age + ", EIF: " +
                    (employee2.driveCar() + employee2.driveBike() +
                            employee2.sing() + employee2.officeWork()));
        }
        scanner.close();
    }

    public static void sort(Employee2[] employee2s, int[] eifValues) {
        int n = employee2s.length;
        Employee2 tempEmployee2;
        int tempEIF;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (eifValues[j] > eifValues[j + 1]) {

                    tempEmployee2 = employee2s[j];
                    employee2s[j] = employee2s[j + 1];
                    employee2s[j + 1] = tempEmployee2;

                    tempEIF = eifValues[j];
                    eifValues[j] = eifValues[j + 1];
                    eifValues[j + 1] = tempEIF;
                }
            }
        }
    }
}
