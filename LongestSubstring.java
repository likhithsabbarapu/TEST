import java.util.HashSet;

///Moderate: Longest Substring Without Repeating Characters
///
/// Concept: The Sliding Window.
/// The Challenge: Find the length of the longest substring that has no duplicate letters.
///
///     Example: "abcabcbb" → Output: 3 ("abc" is the longest).
///
/// The Logic:
/// Think of a Sliding Window (a left and right boundary).
///
///     Move the right boundary to add a new character.
///
///     Use a HashSet to remember what characters are in your window.
///
///     The Logic Move: If the new character is already in the set, shrink the left boundary until the duplicate is gone.
///
///     Keep track of the maximum size the window ever reached.

public class LongestSubstring {
    public static void main(String[] args) {
        String s="Likhith";
        System.out.println("Longest substring length: "+lenghtOfLongestSubstring(s));
    }

public static int lenghtOfLongestSubstring(String s) {
    HashSet<Character> set = new HashSet<>();
    int left=0,maxLength=0;

    for (int right=0;right<s.length();right++) {
        //If duplicate found, slide left boundary
        while (set.contains(s.charAt(right))) {
            set.remove(s.charAt(left));
            left++;
        }
        set.add(s.charAt(right));
        maxLength = Math.max(maxLength, right - left + 1);
    }
    return maxLength;
    }

}
