package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsProblem {

    public static void main(String[] args) {
        List<String> list = List.of("Vaibhav", "sumAnth", "gOOgle");

//        // decapitalize all the words
//
//        Stream<String> stream1 = list.stream();
//
//        List<String> result = stream1.map((String str) -> str.toLowerCase()).collect(Collectors.toList());
//
//        for (String res : result) {
//            System.out.println(res);
//        }

        list.stream().map(str -> str.toLowerCase()).forEach(System.out::println);
    }
}
