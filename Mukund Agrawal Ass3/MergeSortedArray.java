import java.util.Scanner;

public class MergeSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size of the First Array:");
        int size1 = sc.nextInt();

        int[] Array1 = new int[size1];

        System.out.println("Enter the elements of First sorted Array ");

        for (int i = 0; i < size1; i++) {
            Array1[i] = sc.nextInt();
        }

        System.out.println("Size of the Second Array:");
        int size2 = sc.nextInt();

        int[] Array2 = new int[size2];

        System.out.println("Enter the elements of Second sorted Array ");

        for (int i = 0; i < size2; i++) {
            Array2[i] = sc.nextInt();
        }

        sc.close();

        int[] sortedarray = mergeArray(Array1, Array2);

        System.out.println("The Sorted Array is : ");
        for (int w = 0; w < sortedarray.length; w++) {
            System.out.print(sortedarray[w] + " ");
        }
    }

    public static int[] mergeArray(int[] Array1, int[] Array2) {

        int[] sortedarray = new int[Array1.length + Array2.length];

        int k = 0, l = 0, m = 0;
        for (; k < Array1.length && l < Array2.length;) {
            if (Array1[k] < Array2[l]) {
                sortedarray[m++] = Array1[k++];
            } else {
                sortedarray[m++] = Array2[l++];
            }
        }

        while (k < Array1.length) {
            sortedarray[m++] = Array1[k++];
        }
        while (l < Array2.length) {
            sortedarray[m++] = Array2[l++];
        }

        return sortedarray;
    }
}