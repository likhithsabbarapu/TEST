import java.util.ArrayList;


public class TestCode
{
    public static void main(String[] args)
    {
        String [] s={"Likhith","Mahesh","Yukthika","Salman"};
        int n=s.length;
         String temp="";
        //Manual Bubble sorting
        for(int i=0;i<n-1;i++) // for traversal
        {
            for(int j=0;j<n-i-1;j++){ // as the value of i increases one element at the end will be sorted
                if(s[j].compareTo(s[j+1]) >0){ //if the element gives positive number it'll be swapped
                    temp=s[j];
                    s[j]=s[j+1];
                    s[j+1]=temp;
                }

            }
        }
        for(String s1:s){ // display loop it'll print all the values in s
            System.out.println(s1+" ");
        }

        }
    }

