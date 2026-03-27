import java.util.ArrayList;
public class Lamda {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(9);
        numbers.forEach((n)->{System.out.println(n);});

        for(Integer i:numbers){
            System.out.println(i);
        }
    }
}
