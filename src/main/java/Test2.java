import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrays=new ArrayList<>(Arrays.asList(1,2,3,2,100,101));
        Stream<Integer> stream=arrays.stream();
//        stream.filter(x->x>3).map(x->x+100).filter(x->x<3).map(x->x-100).collect(Collectors.toList());
        System.out.println(stream.map(x-> { if(x<3) {x=x-100;} else {x=x+100;}
            return x; } ).collect(Collectors.toList()));
        Stream<Integer> stream2=arrays.stream();
        System.out.println(stream2.distinct().collect(Collectors.toList()));
//        HashSet<Integer> countryHashSet = new HashSet<>();
//        countryHashSet.addAll(arrays);
//        for (Integer a :countryHashSet) {
//            System.out.println(a);
//        }

    }
}
