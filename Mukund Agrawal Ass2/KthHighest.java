import java.util.Scanner;

public class KthHighest {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the size of the array:");
        
        int size = sc.nextInt();
        
        int[] array = new int[size];
        
        System.out.println("Enter the elements of the array:");
        
        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }
        
        System.out.println("Enter an integer k:");
        
        int k = sc.nextInt();
        
        sc.close();
        
        sortArray(array);
        
        printKthHighest(array, k);
    }
    
    public static void sortArray(int[] array) {
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    public static void printKthHighest(int[] array, int k) {
        
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
