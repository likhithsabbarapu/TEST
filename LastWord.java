/* Simple: Length of Last Word

Concept: String Trimming and Backward Traversal.
The Challenge: Given a string s consisting of words and spaces, return the length of the last word in the string.

    Example: "   fly me   to   the moon  " → Output: 4 (The last word is "moon").

The Logic:
Instead of splitting the whole string (which uses extra memory), we walk backwards:

    Start from the very end of the string.

    Skip any trailing spaces.

    Once you hit a letter, start counting until you hit another space. */

import java.sql.SQLOutput;

public class LastWord {
    public static void main(String[] args){
        String s="Fly me to the moon   ";
        System.out.println("Length of the last word: "+lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int length=0;
        int i=s.length()-1;

        //Step -1 Skip spaces at the end
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        while(i>=0 && s.charAt(i)!=' '){
            length++;
            i--;
        }
        return length;
    }
}
