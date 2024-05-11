
import java.util.*;

    public class ArrayListInteger {
        public static void main(String[] args) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                int randomInt = random.nextInt(100);
                arrayList.add(randomInt);
            }
            System.out.println("Elements in the ArrayList:");
            for (Integer num : arrayList) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.print("Enter an integer to check if it's present in the ArrayList: ");
            int numberToCheck = scanner.nextInt();
            if (arrayList.contains(numberToCheck)) {
                arrayList.remove(Integer.valueOf(numberToCheck));
                System.out.println("Integer " + numberToCheck + " removed from the ArrayList.");
            } else {
                System.out.println("Integer " + numberToCheck + " is not present in the ArrayList.");
            }
            System.out.println("Updated ArrayList:");
            for (Integer num : arrayList) {
                System.out.print(num + " ");
            }
            scanner.close();
        }
    }

