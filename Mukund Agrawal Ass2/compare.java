import java.util.Scanner;

public class compare {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three different numbers:");

        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        double num3 = sc.nextDouble();

        sc.close();

        double largest = 0;
        double largest1 = 0;

        if (num1 > num2 && num1 > num3) {
            largest = num1;
        } else if (num2 > num1 && num2 > num3) {
            largest = num2;
        } else {
            largest = num3;
        }

        System.out.println("The largest number among " + num1 + ", " + num2 + ", and " + num3 + " is: " + largest);

        largest1 = (num1 > num2 && num1 > num3) ? num1 : (num2 > num1 && num2 > num3) ? num2 : num3;

        System.out.println("The largest number among " + num1 + ", " + num2 + ", and " + num3 + " is: " + largest1);
    }
}
