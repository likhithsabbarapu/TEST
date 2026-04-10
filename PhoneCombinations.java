//The Challenge: Letter Combinations of a Phone Number
//
//Problem: Given a string containing digits from 2-9 inclusive (like the old Nokia T9 keyboards), return all possible letter combinations that the number could represent.
//
//    Example: digits = "23"
//
//    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//    (Because 2 is "abc" and 3 is "def")
//For a Developer (The Recursive Backtracking)
//
//In programming, we use Recursion to act as our "memory" of which path we are on.
//The Technical Strategy
//
//    The Map: We use a String[] or HashMap to map digits to letters (e.g., mapping[2] = "abc").
//
//    The State: We track two things: the current string we are building and the index of the digit we are currently looking at.
//
//    The Base Case: If our current string's length equals the input digits' length, we’ve reached a "leaf" of the tree. Add it to our list!
//
//    The Loop: For the current digit, loop through all its possible letters, add one to our path, and call the function again for the next digit.


// Save as PhoneCombinations.java
import java.util.*;

public class PhoneCombinations {
    // Map of digits to letters
    private static final String[] MAPPING = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        String digits = "23";
        System.out.println("Combinations for " + digits + ": " + letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        // Start the recursive process
        backtrack(result, digits, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String digits, String current, int index) {
        // BASE CASE: If the combination is done
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters for the current digit (e.g., '2' -> "abc")
        String letters = MAPPING[digits.charAt(index) - '0'];

        // RECURSIVE STEP: Try every letter for this digit
        for (char c : letters.toCharArray()) {
            backtrack(result, digits, current + c, index + 1);
        }
    }
}