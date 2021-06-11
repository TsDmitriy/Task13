import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList("a1","a2","a3","a1","a55"));
//        Stream<String> stream =array.stream();
//        System.out.println(stream.filter(x->x.equals("a1")).count()); /// - вернет количество поваторов
//        Stream<String> stream2 =array.stream();
//        System.out.println(stream2.findFirst().orElse("0")); /// - первый элемент из стрима bkb 0
        Stream<String> stream3 =array.stream();
        System.out.println(stream3.skip(array.size()-1).findAny().orElse("empty")); /// - последний элемент коллекции и empty
        Stream<String> stream4 =array.stream();
        System.out.println(stream4.filter(x->x.equals("a3")).findFirst().get()); /// - найти элемент а3
        Stream<String> stream5 =array.stream();
        System.out.println(stream5.skip(2).findFirst().get()); /// - найти 3 делемент в коллекции
        Stream<String> stream6 =array.stream();
        System.out.println(stream6.skip(1).limit(2).toArray()); /// - берет 2 и 3 элемент
        Stream<String> stream7 =array.stream();
        System.out.println(stream7.filter(x->x.contains("2")).collect(Collectors.toList())); /// - содержит 2
        Stream<String> stream8 =array.stream();
        System.out.println(stream8.distinct().collect(Collectors.toList())); /// - уникальные
        Stream<String> stream9 =array.stream();
        System.out.println(stream9.anyMatch(x->x.equals("a1"))); /// - содержится ли а1 у одого элемента коллекции
        Stream<String> stream10 =array.stream();
        System.out.println(stream10.allMatch(x->x.equals("1"))); /// - содержится ли  у всех элементов коллекции
        Stream<String> stream11 =array.stream();
        System.out.println(stream11.map(x->x + "s").collect(Collectors.toList())); /// - содержится ли  у всех элементов коллекции
    }
}
