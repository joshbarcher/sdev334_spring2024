package structures;

import java.util.Arrays;

public class IntegerPQ implements IPriorityQueue {
    private static final int INITIAL_CAPACITY = 10;

    //min heap!
    private int[] heap;
    private int size;

    public IntegerPQ() {
        heap = new int[INITIAL_CAPACITY];
    }

    @Override
    public void add(int element) {
        //check if we ran out of room in the array
        if (size == heap.length) {
            resize();
        }

        //add the element to the next available index
        heap[size] = element;

        //swim up the tree
        swim(size);
        size++;
    }

    private void resize() {
        int[] newHeap = new int[heap.length * 2];

        //copy elements to the new heap
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }

        //use the new heap
        heap = newHeap;
    }

    private void swim(int index) {
        //given index i, the parent is at (i-1)/2

        //continue until we reach the root
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            //are they out of order
            if (heap[index] < heap[parentIndex]) {
                swap(index, parentIndex);

                //move up the tree
                index = parentIndex;
            } else {
                //in order - short circuit
                break;
            }
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    @Override
    public int remove() {
        checkEmpty();

        int saved = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = 0;

        size--;
        sink(0);

        return saved;
    }

    private void sink(int index) {
        int highestIndexWithChild = (size / 2) - 1;

        while (index <= highestIndexWithChild) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            //which is the smaller child
            int smallestIndex = leftIndex;
            if (rightIndex < size &&
                heap[rightIndex] < heap[leftIndex]) {
                smallestIndex = rightIndex;
            }

            //swap if out of order
            if (heap[index] > heap[smallestIndex]) {
                swap(index, smallestIndex);

                //move down to the child element
                index = smallestIndex;
            } else {
                //stop - short circuit
                break;
            }
        }
    }

    private void checkEmpty()
    {
        if (size == 0) {
            throw new IllegalStateException("Empty heap!");
        }
    }

    @Override
    public int peek() {
        checkEmpty();

        return heap[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
