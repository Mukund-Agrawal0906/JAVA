import java.util.Scanner;

public class Commonelements {
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

        System.out.println("Size of the Third Array:");
        int size3 = sc.nextInt();

        int[] Array3 = new int[size3];

        System.out.println("Enter the elements of Third sorted Array ");

        for (int i = 0; i < size3; i++) {
            Array3[i] = sc.nextInt();
        }
        sc.close();
        int min = 0;

        if (size1 <= size2) {
            if (size1 <= size3) {
                min = size1;
            } else
                min = size3;
        } else {
            if (size2 <= size3) {
                min = size2;
            } else
                min = size3;
        }

        int[] common = new int[min];
        common=same(Array1,Array2,Array3,min);

        System.out.println("The Common Elements are : ");
        for (int w = 0; w < common.length; w++) {
            System.out.print(common[w] + " ");
        }

    }

    public static int[] same(int[]Array1,int[]Array2,int[]Array3,int min){
        int i = 0, j = 0, k = 0, l = 0;
        int[] common = new int[min];
        while (i < Array1.length && j < Array2.length && k < Array3.length) {
            if (Array1[i] == Array2[j] && Array2[j] == Array3[k]) {
                common[l++] = Array1[i];
                i++;
                j++;
                k++;
            } else if (Array1[i] < Array2[j]) {
                i++;
            } else if (Array2[j] < Array3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return common;
    }
}
