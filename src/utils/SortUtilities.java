package utils;

import java.util.Random;

public class SortUtilities {
    public static int[] generateArray(int length, int min, int max) {
        int[] results = new int[length];
        Random random = new Random();

        //loop over the array and enter random numbers into the array
        for (int i = 0; i < results.length; i++) {
            int randNum = random.nextInt(max - min + 1) + min;
            results[i] = randNum;
        }

        return results;
    }

    public static boolean detectInversions(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return true; //unsorted!
            }
        }
        return false; //sorted!
    }
}
