package basic_sorts;

import utils.SortUtilities;

import java.util.Arrays;

public class SortTester {
    public static void main(String[] args) {
        int[] testArray = SortUtilities.generateArray(1000000, 1, 1000000);

        //print, sort, then print again!
        //System.out.println(Arrays.toString(testArray));
        System.out.println("Starting the sort!");
        BubbleSort.sort(testArray);
        System.out.println("Ended the sort!");
        //System.out.println(Arrays.toString(testArray));

        boolean isSorted = !SortUtilities.detectInversions(testArray);
        System.out.println("Is it sorted? " + isSorted);
    }
}
