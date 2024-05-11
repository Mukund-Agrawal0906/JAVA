import java.util.Scanner;

public class largest {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        
        int size = sc.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Enter the elements of the array:");
        
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        
        sc.close();

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < size; i++) {
            if (array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            }
            else if (array[i] > secondLargest && array[i] != largest) {
                secondLargest = array[i];
            }
        }
        
        System.out.println("The largest element of the array is: " + largest);
        System.out.println("The second largest element of the array is: " + secondLargest);
        
    }
}

