package structure;

import java.util.Arrays;

public class DisjointSets {
    private int[] sets;

    public DisjointSets(int numElements) {
        sets = new int[numElements];
        Arrays.fill(sets, -1);
    }

    public int find(int element) {
        if (sets[element] < 0) { //is this the root?
            return element;
        } else { //search recursively for the root
            return find(sets[element]);
        }
    }

    public boolean union(int first, int second) {
        //get the roots
        int firstRoot = find(first);
        int secondRoot = find(second);

        //make sure roots are different
        if (firstRoot == secondRoot) {
            return false; //same set!!!
        }

        //compare heights of roots
        if (sets[firstRoot] < sets[secondRoot]) {
            //firstRoot is the new root of the joined tree
            sets[secondRoot] = firstRoot;
        } else if (sets[secondRoot] < sets[firstRoot]) {
            //secondRoot is the new root of the joined tree
            sets[firstRoot] = secondRoot;
        } else {
            //pick arbitrarily the new root
            sets[secondRoot] = firstRoot;

            //increase the tree height
            sets[firstRoot]--;
        }

        return true;
    }

    public boolean sameSet(int first, int second) {
        return find(first) == find(second);
    }

    public boolean notSameSet(int first, int second) {
        return find(first) != find(second);
    }

    @Override
    public String toString() {
        return Arrays.toString(sets);
    }
}
