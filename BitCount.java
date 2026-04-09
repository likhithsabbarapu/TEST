///Hamming Weight (Number of 1 Bits)
///
/// Concept: Bit Manipulation.
/// The Challenge: Given an integer, return the number of "1" bits it has (also known as the Hamming weight).
///
///     Example: 11 in binary is 1011. The output is 3.
///
/// The Logic:
/// Instead of converting the number to a string, we use the Bitwise AND operator (&).
///
///     n & 1 tells us if the last bit is a 1.
///
///     We then "shift" the bits to the right using >>> to look at the next bit.
///
///     Repeat until the number becomes 0.

public class BitCount {
    public static void main(String [] args) {
        int n=111;
        System.out.println("Number of bits in "+n+": "+hammingWeiht(n));
    }
    public static int hammingWeiht(int n){
        int count =0;
        while(n!=0){
            count+=(n&1); //Add 1 if the last bit is 1
            n>>>=1;       //Shift bits to the right
        }
        return count;
    }
}
