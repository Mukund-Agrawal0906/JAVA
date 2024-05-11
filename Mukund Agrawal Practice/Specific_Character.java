import java.util.Scanner;

public class Q4 {
    static void shift_alphabet(char[] ch, char target) {
        char[] ans = new char[ch.length];
        int j=0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != target) {
                ans[j] = ch[i];
                j++;
            }
        }
        while(j< ans.length)
        {
            ans[j]=target;
            j++;
        }
        System.out.println("Entered answer ARRAY is : ");
        for (char c : ans) {
            System.out.print(" " + c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter characters separated by spaces: ");
        String s1 = sc.nextLine();

        // Use split to get character array
        char[] ch = s1.replaceAll("\\s+", "").toCharArray();

        System.out.println("Entered character ARRAY is : ");
        for (char c : ch) {
            System.out.print(" " + c);
        }

        System.out.println("\nEnter target alphabet :");
        String s2 = sc.next();
        char target = s2.charAt(0);
        shift_alphabet(ch, target);
    }
}
