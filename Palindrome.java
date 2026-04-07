/*Simple: Palindrome Number

Concept: Integer Manipulation (No Strings allowed!)
The Challenge: Determine if an integer is a palindrome (reads the same backward as forward).

    Example: 121 is true. -121 is false (reads as 121-).

The Logic:
Instead of converting to a String, we "flip" the number mathematically.

    Take the last digit: number % 10.

    Build the reverse: (reverse * 10) + lastDigit.

    Chop off the last digit: number / 10. */

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
