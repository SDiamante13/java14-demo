package main.java.tech.pathtoprogramming.java14demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person(new Name("Sam", "Adams"), new Guitar("Fender", true), 1000),
                new Person(new Name("George", "Thomas"), new Guitar("Gibson", true), 2000),
                new Person(new Name("Billy", "Tank"), new Guitar("Yamaha", false), 4000)
        );

        /** Switch Expression
         * --------------------------------------------------------------------------------------
         ** */

        int number = switch (people.get(0).name().firstName()) {
            case "Sam", "Billy" -> 1;
            case "George", "Phil" -> 2;
            default -> 0;
        };

        System.out.println(number);

        /** Text Blocks
         * --------------------------------------------------------------------------------------
         ** */
        String helloWorld = """
                Hello from Path to Programming
                This is a multi-line string
                """;

        String helloWorld2 = "Hello from Path to Programming\n" +
                "This is a multi-line string";

        System.out.println(helloWorld);
        System.out.println(helloWorld2);

        /** instanceof
         * --------------------------------------------------------------------------------------
         ** */

        Object obj = "today  ";

        if (obj instanceof String today) {
            System.out.println(today.trim());
        }

        /** var
         * --------------------------------------------------------------------------------------
         ** */

        var greeting = "Hello";

        System.out.println(greeting);

        /** Collection.teeing JDK 12
         * --------------------------------------------------------------------------------------
         ** */

        people.forEach(System.out::println);

        Map<String, Person> result = people.stream().collect(
                Collectors.teeing(
                        Collectors.maxBy(Comparator.comparing(Person::salary)),
                        Collectors.minBy(Comparator.comparing(Person::salary)),
                        (e1, e2) -> {
                            Map<String, Person> map = new HashMap<>();
                            map.put("MAX", e1.get());
                            map.put("MIN", e2.get());
                            return map;
                        }

                )
        );

        System.out.println(result);


        /** String enhancements -- indent, transform, isBlank, lines, repeat, and strip
         * --------------------------------------------------------------------------------------
         ** */
        System.out.println("String enhancements");

        String learning = """
                Let's learn Java 14
                Path To Programming
                """;

        System.out.println(learning);

        System.out.println(learning.indent(4));
        System.out.println(learning.transform((Function<String, String>) s ->
                s.replaceAll("a", "A")));
        String blank = "    ";
        String empty = "";
        System.out.println(blank.isBlank());
        System.out.println(blank.isEmpty());
        System.out.println(empty.isBlank());
        System.out.println(empty.isEmpty());

        System.out.println(learning.lines().findFirst().get().repeat(2));

        String trim = "    trimmed      ";
        String strip = "    stripped    ";

        System.out.println(trim.trim());
        System.out.println(trim.trim().length());
        System.out.println(strip.strip());
        System.out.println(strip.strip().length());
    }
}
