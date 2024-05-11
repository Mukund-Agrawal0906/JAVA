import java.util.Arrays;
import java.util.Scanner;

public class pushtolast {

    public static void main(String[] args) {
        int[] arr1 = create_array();

        shiftzeros(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    static int[] shiftzeros(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        while (count < arr.length) {
            arr[count] = 0;
            count++;
        }

        return arr;
    }

    static int[] create_array() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();

        System.out.println("Enter elements of array");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        return arr;

    }
}