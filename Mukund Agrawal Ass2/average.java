import java.util.Scanner;

public class average {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Size of the Array:");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        
        System.out.println("Enter the elements of the array:");
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        sc.close();
        
        double sum = 0;
        
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        
        double avg = sum / size;
        
        System.out.println("The average of the elements of the array is: " + avg);
    }
}