// The Challenge: Group Anagrams
//
//Problem: Given an array of strings, group the anagrams together. An anagram is a word formed by rearranging the letters of a different word (like "eat", "tea", and "ate").
//
//    Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
//
//    Goal: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
//For a Developer (The HashMap + Sorting Strategy)
//
//In Java, we use a HashMap where the Key is the sorted string and the Value is a List of all original strings that match that key.
//The Technical Strategy
//
//    Iterate: Loop through each string in the input array.
//
//    Normalize: Convert the string to a character array, sort it, and convert it back to a string. This is our "Key."
//
//    Store: Check if the key exists in our HashMap.
//
//        If not, create a new ArrayList.
//
//        Add the original word to the list associated with that key.
//
//    Return: The result is just all the values (the lists) inside our map.
import java.util.*;

public class AnagramGrouper {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> grouped = groupAnagrams(words);

        System.out.println("Grouped Anagrams: " + grouped);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        // Map: Sorted version of word -> List of actual words
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // 1. Sort the characters to create a unique key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            // 2. Put the word into its corresponding bucket
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        // Return only the values (the groups)
        return new ArrayList<>(map.values());
    }
}


//Categorization: This is the foundation of data organization. Instead of comparing every word to every other word (O(N2)), we use a "Signature" (the sorted key) to group them in O(N) passes through the array.

//The Power of Hashing: By using a HashMap, we get near-instant lookup time. It shows how choosing the right "Key" can simplify a complex problem.

//Space vs. Time: We use extra space (the Map) to gain massive speed. Sorting each string takes KlogK time (where K is the length of the longest word), making the total complexity O(N⋅KlogK).