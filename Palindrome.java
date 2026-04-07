import java.sql.SQLOutput;

public class Palindrome {
    public static void main(String[] args) {
        int test=121;

        System.out.println("Is "+test+" a palindrome?"+isPalindrome(test));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) return false; //Negetive numbers are nerver palindromes
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10; // Get the last digit
            reversed = reversed * 10 + digit; // Append it to the reversed number
            x /= 10; // Remove the last digit
        }
        return original == reversed; // Check if the original and reversed numbers are the same
    }
}
