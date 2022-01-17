package com.Java8Features.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        //Stream<T> filter (Predicate)
        System.out.println("filter: ");
        numbers.stream().filter(n -> n % 2 == 0).forEach(d -> System.out.print(d + " "));

        // Stream < T > map(Function)
        System.out.println("\nmap: ");
        numbers.stream().map(n -> n + 1).forEach(d -> System.out.print(d + " "));

        //Stream<T> flatMap (Function)
        System.out.println("\nflatMap: ");
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(4, 5);
        List<Integer> list3 = Arrays.asList(6, 7);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.stream().flatMap(s -> s.stream()).forEach(d -> System.out.print(d + " "));

        // Stream < T > distinct()
        List<Integer> numbers1 = Arrays.asList(0, 0, 2, 2, 4, 5, 6, 5, 8, 4);
        System.out.println("\ndistinct: ");
        numbers1.stream().distinct().forEach(d -> System.out.print(d + " "));

        //Stream<T> sorted (Comparator)
        List<Integer> numbers2 = Arrays.asList(8, 10, 2, 42, 74, 54, 6, 15, 78, 14);
        System.out.println("\nsorted: ");
        numbers2.stream().sorted().forEach(d -> System.out.print(d + " "));

        //Stream<T> limit (long)
        System.out.println("\nlimit: ");
        numbers.stream().limit(3).forEach(d -> System.out.print(d + " "));

        //forEach(Consumer)
        System.out.println("\nConsumer: ");
        numbers.stream().forEach(d -> System.out.print(d + " "));

        //Object[] toArray ()
        System.out.println("\ntoArray: ");
        Object[] num = numbers.stream().toArray();
        for (Object i : num) {
            System.out.print(i + " ");
        }
        //Optional<T> reduce (identity, accumulator)
        System.out.println("\nreduce: ");
        Optional<Integer> reduce = numbers.stream().reduce((identity, accumulator) -> identity + accumulator);
        System.out.print(reduce.get());

        //<R, A > R collect(Collector)
        System.out.println("\ncollect: ");
        List<Integer> integerList = numbers.stream().map(d -> d * 10).collect(Collectors.toList());
        System.out.print(integerList);

        //Optional<T> min (Comparator)
        System.out.println("\nmin: ");
        Optional<Integer> min = numbers.stream().min((a, b) -> a.compareTo(b));
        System.out.print(min.get());

        //Optional < T > max(Comparator)
        System.out.println("\nmax: ");
        Optional<Integer> max = numbers.stream().max((a, b) -> a.compareTo(b));
        System.out.print(max.get());

        //long count ()
        System.out.println("\ncount: ");
        long count = numbers.stream().filter(d -> d > 5).count();
        System.out.print(count);

        //boolean anyMatch (Predicate)
        System.out.println("\nanyMatch: ");
        boolean anyMatch = numbers.stream().anyMatch(d -> d % 2 == 0);
        System.out.print(anyMatch);

        //boolean allMatch (Predicate)
        System.out.println("\nallMatch: ");
        boolean allMatch = numbers.stream().allMatch(d -> d % 2 == 0);
        System.out.print(allMatch);

        //boolean noneMatch (Predicate)
        System.out.println("\nnoneMatch: ");
        boolean noneMatch = numbers.stream().allMatch(d -> d % 2 == 0);
        System.out.print(noneMatch);

        //Optional < T > findFirst()
        System.out.println("\nfindFirst: ");
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.print(first.get());

        //Optional<T> findAny ()
        System.out.println("\nfindAny: ");
        Optional<Integer> any = numbers.stream().findFirst();
        System.out.print(any.get());
    }
}
