import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

interface MathOp
{
    int add1(int a,int b);
}
public class LambdaTest {
    public static void main(String[] args) {
        MathOp add=(a,b)->(a-b);
        System.out.println(add.add1(1,2));

        //intermediate

        List<String> names = Arrays.asList("Likhith", "Arjun", "Bhavya", "Zoya");

        // Use forEach with a Lambda to print everything
        System.out.println("Original List:");
        names.forEach(name -> System.out.println("Hello, " + name));

        // Use a Lambda to sort (revisiting our sorting logic!)
        // (s1, s2) -> s1.compareTo(s2) is the logic
        names.sort(String::compareTo);

        System.out.println("\nSorted List: " + names);

        //Advanced code
        List<String> lists = Arrays.asList("Likhith", "Likki", "Laxman", "Bhavya", "Zoya","Lalitha");

        List<String> result = lists.stream()
                .filter(n -> n.startsWith("L"))         // Lambda for filtering
                .map(String::toUpperCase)               // Method Reference (even shorter than lambda!)
                .sorted()                               // Natural sorting
                .collect(Collectors.toList());          // Gathering the result

        System.out.println(result); // Output


        //Practice
        List<String> players=Arrays.asList("Likhith","Nani","Prem","Mohan","Max");
        List<String> players2= new ArrayList<>(players);
        players2.add("Himaja");players2.add("Bhavna");players2.add("Zoya");
        players.forEach(p->System.out.println("Level Up, "+p+"!"));
        players2.sort(String::compareTo);
        System.out.println(players2);

        //Streams practice
        List<Integer> num=Arrays.asList(100,60,73,64,85);
        List<Integer> grade=num.stream()
                .filter(g->g>=35)
                .toList();
        int totalGrade=grade.stream()
                        .filter(p->p>=35)
                                .mapToInt(p->p)
                                        .sum();
        System.out.println("Total marks scored: "+totalGrade+"/500");
        System.out.println(grade);

        List<String> output=players2.stream()
                .filter(name->name.startsWith("M"))
                .map(String::toUpperCase)
                .toList();
        System.out.println(output);

        //list of order and the square

        List<Integer> numbers=Arrays.asList(100,60,73,64,85);
        List<Integer> SqNum=numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .map(n->n*n)
                .toList();
        System.out.println(SqNum);

    }

}
