import java.util.*;
import java.util.stream.*;
import java.util.Collections;
public class Integers {
    public static void main(){
     List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
     Set<Integer> items= new HashSet<Integer>();
     Set<Integer> duplicates=items.stream().filter(i->!list.add(i)).collect(Collectors.toSet());

    }
}