package test;

import structure.DisjointSets;

public class Main {
    public static void main(String[] args) {
        DisjointSets sets = new DisjointSets(10);
        System.out.println(sets);

        sets.union(1, 2);
        sets.union(2, 4);
        sets.union(3, 1);

        //how many sets do we have now?
        System.out.println(sets.find(0));
        System.out.println(sets.find(1));
        System.out.println(sets.find(4));
    }
}
