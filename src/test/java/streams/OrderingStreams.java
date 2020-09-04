package streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderingStreams {

    // 1..10 | 11..20 | 21..30 | 31..40
    //  L1       L2       L3       L4
    //                L
    @Test
    void findEvens() {
        ArrayList<Integer> evens = IntStream.range(100, 200)
                                            .parallel()
                                            .filter(n -> n % 2 == 0)
                                            .collect(ArrayList::new,    // Supplier
                                                    ArrayList::add,     // BiConsumer (accumulator)
                                                    ArrayList::addAll); // BiConsumer (combiner)
        System.out.println(evens);
    }

    @Test
    void findEvensBoxed() {
        List<Integer> evens = IntStream.range(100, 200)
                                       .parallel()
                                       .filter(n -> n % 2 == 0)
                                       // .mapToObj(Integer::valueOf)  // Stream<Integer>
                                       .boxed()                        // Stream<Integer>
                                       .collect(Collectors.toList());
        System.out.println(evens);
    }

    @Test
    void findEvensWithForEach() {
        List<Integer> evens = new ArrayList<>();
        IntStream.range(100, 200)
                 .parallel()
                 .filter(n -> n % 2 == 0)
                 .forEach(evens::add); // show does not respect ordering
        System.out.println(evens);
    }
}
