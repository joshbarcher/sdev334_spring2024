package test;

import structures.Bag;

import java.util.Iterator;

public class BagTest {
    public static void main(String[] args) {
        Bag marbles = new Bag(8);

        marbles.add("green");
        marbles.add("red");
        marbles.add("blue");
        marbles.add("yellow");

        System.out.println(marbles);

        for (Object marble : marbles) {
            System.out.println("Here is a " + marble + " marble!");
        }
    }
}
