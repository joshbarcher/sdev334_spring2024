package test;

import structures.IntegerPQ;

public class QueueTests {
    public static void main(String[] args) {
        IntegerPQ queue = new IntegerPQ();
        int[] elementsToAdd = {78, 45, 13, 22, 150, 99, 1, 4};

        //add to the queue
        for (int element : elementsToAdd) {
            queue.add(element);
        }

        System.out.println(queue);

        //is our queue working?
        while (!queue.isEmpty()) {
            int element = queue.remove();
            System.out.println(element);
        }
    }
}
