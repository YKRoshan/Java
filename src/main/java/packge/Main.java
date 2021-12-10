package packge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Given an input string give the order of characters in a decreasing frequency.
 * If two characters have the same frequency - they are ordered
 * lexicographically. "this is a blume engineering interview"
 * [e=6, i=6, n=4, g=2, r=2, s=2, t=2, a=1, b=1, h=1, l=1, m=1, u=1, v=1, w=1]
 */

public class Main {
    public static void main(String[] args) {
        String str = "this is a blume engineering interview";

        printFreq(str);
    }

    private static void printFreq(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            if (map.containsKey(str.charAt(i))) {
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        Stream<Map.Entry<Character, Integer>> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        // .forEach(d-> System.out.print(d+" "));
//        map.keySet().stream().sorted((o1, o2) -> -map.get(o2).compareTo(map.get(o2)))
//            .forEach(d-> System.out.print(d+"->"+map.get(d)+" "));
//        Set<Character> keys = map.keySet();
//        List<Character> list = new ArrayList<>();
//        list.addAll(keys);
//        Collections.sort(list, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
//        list.forEach(v -> {
//            System.out.print(v + "->" + map.get(v) + "\t");
//        });
    }
}
