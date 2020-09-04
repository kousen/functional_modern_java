package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {
    @SuppressWarnings({"UnusedAssignment", "Convert2MethodRef"})
    public static void main(String[] args) {
        List<String> names = List.of("John", "Paul", "George", "Ringo");

        // Old-style Java 7- way
        List<Person> beatles = new ArrayList<>();
        for (String name : names) {
            beatles.add(new Person(name));
        }
        System.out.println("Beatles: " + beatles);

        List<Person> people = names.stream()    // Stream<String>
                                   .map(name -> new Person(name))  // Stream<Person>
                                   .collect(Collectors.toList());  // Converts Stream<Person> to List<Person>
        System.out.println(people);

        people = names.stream()
                      .peek(name -> System.out.println(Thread.currentThread().getName() + ": " + name))
                      .map(Person::new)  // use the one-arg ctor in Person that takes a String arg
                      .collect(Collectors.toList());
        System.out.println(people);

        Person[] peopleArray = names.stream()
                                    .map(Person::new)
                                    .toArray(Person[]::new);
        System.out.println(Arrays.toString(peopleArray));
    }
}
