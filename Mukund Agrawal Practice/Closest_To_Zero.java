

    import java.util.*;

    public class Closest_To_Zero {
        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.println("Enter the size of the array: ");
            int n= scan.nextInt();
            int arr[] = new int[n];
            System.out.println("Enter the Elements of the array: ");
            for (int i=0;i<n;i++){
                arr[i]= scan.nextInt();
            }
            int[] closestPair = findClosestSumToZero(arr);

            if (closestPair != null) {
                int sum = closestPair[0] + closestPair[1];
                System.out.println("Closest pair: " + closestPair[0] + " and " + closestPair[1]);
                System.out.println("Sum of closest pair to zero: " + sum);
            } else {
                System.out.println("No pair found with a sum closest to zero.");
            }
            scan.close();
        }

        public static int[] findClosestSumToZero(int[] arr) {
            if (arr == null || arr.length < 2) {
                return null;
            }

            Arrays.sort(arr);
            int left = 0;
            int right = arr.length - 1;
            int closestSum = Integer.MAX_VALUE;
            int[] closestPair = new int[2];

            while (left < right) {
                int sum = arr[left] + arr[right];
                int absSum = Math.abs(sum);

                if (absSum < Math.abs(closestSum)) {
                    closestSum = sum;
                    closestPair[0] = arr[left];
                    closestPair[1] = arr[right];
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            return closestPair;
        }
    }

