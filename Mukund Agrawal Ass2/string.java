import java.util.Scanner;

public class string {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a sentence:");
        
        String sentence = sc.nextLine();
        
        sc.close();
        
        countWords(sentence);
        
        printPalindromeWords(sentence);
    }
    
    public static void countWords(String sentence) {
        
        String[] words = sentence.split("\\s+");
        
        int count = words.length;
        
        System.out.println("The number of words in the sentence is: " + count);
    }
    
    public static void printPalindromeWords(String sentence) {
        
        String[] words = sentence.split("\\s+");
        
        System.out.println("The palindrome words in the sentence are:");
        
        for (String word : words) {
            boolean palindrome = isPalindrome(word);
            
            if (palindrome) {
                System.out.print(word + " ");
            }
        }
    }
    
    public static boolean isPalindrome(String word) {
        
        String lowerCaseWord = word.toLowerCase();
        
        int start = 0;
        int end = lowerCaseWord.length() - 1;
        
        while (start < end) {
            if (lowerCaseWord.charAt(start) != lowerCaseWord.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
