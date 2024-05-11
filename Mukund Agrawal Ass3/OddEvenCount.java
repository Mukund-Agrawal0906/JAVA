import java.util.*;

public class OddEvenCount {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the no. of test cases. ");
        n = sc.nextInt();
        int a[][] = new int[n][];
        System.out.println("Enter the elements of first array ");
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter the size of array : %d%n", i + 1);
            int x = sc.nextInt();
            a[i] = new int[x];

            System.out.printf("Enter the %d test case elements: ", i + 1);
            for (int j = 0; j < x; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        evenAndOdd(n, a);
    }

    public static void evenAndOdd(int n, int a[][]) {
        int even = 0;
        int odd = 0;
        int overalleven = 0;
        int overallodd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            overalleven += even;
            overallodd += odd;
            System.out.printf("Even : %d%n", even);
            System.out.printf("Odd : %d%n", odd);
            even = 0;
            odd = 0;
        }

        System.out.printf("Overalleven : %d%n", overalleven);
        System.out.printf("Overallodd : %d%n", overallodd);
    }
}
