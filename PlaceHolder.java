import java.util.ArrayList;
import java.util.Collections;

public class PlaceHolder {



    public static void main(String[] args) {
        PlaceHolder ph = new PlaceHolder();
        ph.array();
    }

    public void array() {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(1);
        numbers.add(7);
        numbers.add(3);
        numbers.add(9);

        Collections.sort(numbers);
        System.out.println(numbers); // [1, 3, 5, 7, 9]
    }
}
