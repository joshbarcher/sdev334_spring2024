package divide_and_conquer;

import java.util.Arrays;

public class TestMergeSort {
    public static void main(String[] args) {
        int[] numbers = {42, 21, 13, 7, 2, 11, 36, 81};

        System.out.println("Before: " + Arrays.toString(numbers));
        MergeSort.mergeSort(numbers);
        System.out.println("After: " + Arrays.toString(numbers));
    }
}
