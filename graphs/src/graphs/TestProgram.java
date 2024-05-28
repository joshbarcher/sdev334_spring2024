package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestProgram {
    private static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        Set<String> set = returnKeys();
        set.clear();

        System.out.println("Loop over set");
        for (String el : map.keySet()) {
            System.out.println(el);
        }
        System.out.println("Keys in map - " + map.size());
    }

    public static Set<String> returnKeys() {
        map.put("foo", "bar");
        map.put("foo2", "bar2");

        //copy over elements to a new set
        return new HashSet<>(map.keySet());
    }
}
