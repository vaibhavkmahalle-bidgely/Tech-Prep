package Stream;
import java.util.*;
import java.util.stream.Stream;

// basic idea : collection -> create stream -> intermediate operation -> terminal operation
// intermediate operation -> filter, map, flatMap.... mapToInt, ... flatMapToInt...(0 or more)
// terminal operations ->
public class CreateStreams {


    public static void main(String[] args) {

        // from collection
        List<Integer> salaryList = Arrays.asList(2,3,4,5,6);
        Stream<Integer> streamFromIntegerList = salaryList.stream();

        // from array
        Integer[] salary = {1,2,3,4,5};
        Stream<Integer> streamFromIntegerArray = Arrays.stream(salary);

//    from static method
        Stream<Integer> streamFromStaticMethod = Stream.of(100,200,300,400);

//    From Stream builder
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(200).add(300);

        Stream<Integer> stream = streamBuilder.build();
        stream.forEach(System.out::println);

    }

}
