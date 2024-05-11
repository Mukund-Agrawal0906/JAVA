import java.util.Scanner;

class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }

    void eat() {
        System.out.println("Person is eating.");
    }

    void sleep() {
        System.out.println("Person is sleeping.");
    }
}

interface Driver {
    void driveCar();

    void driveBike();
}

interface Singer {
    void riyaz();

    void sing();

}

class Employee extends Person implements Driver, Singer {

    public Employee(int age) {
        super(age);
    }

    @Override
    public void driveCar() {

        int result = (age < 40) ? 10 : 0;
        System.out.println("Employee is driving a car. Result: " + result);
    }

    @Override
    public void driveBike() {

        int result = (age < 40) ? 5 : 0;
        System.out.println("Employee is driving a bike. Result: " + result);
    }

    @Override
    public void riyaz() {

        int result = (age < 20) ? 15 : 0;
        System.out.println("Employee is singing. Result: " + result);
    }

    @Override
    public void sing() {

        int result = (age < 20) ? 15 : 0;
        System.out.println("Employee is singing. Result: " + result);
    }

    void officeWork() {
        int result = (age < 40) ? 20 : 10;
        System.out.println("Employee is doing office work. Result: " + result);
    }
}

class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age for the new employee: ");
        int age = scanner.nextInt();

        Employee employee = new Employee(age);

        Driver driver = employee;
        driver.driveCar();
        driver.driveBike();


        Singer singer = employee;
        singer.riyaz();
        singer.sing();


        employee.officeWork();
        scanner.close();
    }
}
