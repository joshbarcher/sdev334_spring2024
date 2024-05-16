package divide_and_conquer;

public class QuickSort {

    //sorts our array
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //sorts a sub-array from low to high
    private static void quickSort(int[] array,
                                  int low, int high) {
        if (low >= high) {
            return;
        }
        else if (high - low + 1 <= 10) {
            insertionSort(array, low, high);
            return;
        }

        //pick my pivot
        medianOfThree(array, low, high);
        int pivot = array[low];

        //partition my data
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < pivot) { i++; }
            while (array[j] > pivot) { j--; }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        //recursively sort the left and right sub-array
        if (low < j) {
            quickSort(array, low, j);
        }

        if (high > i) {
            quickSort(array, i, high);
        }
    }

    //move a pivot to the left-most index according to the median-of-three
    //strategy, and returns the pivot
    private static void medianOfThree(int[] array, int low, int high) {
        //find the middle index
        int mid = (low + high) / 2;

        //sort low, high, mid
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }

        //move the pivot to the left-most position
        swap(array, low, mid);
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static void insertionSort(int[] array, int low, int high)
    {
        // for each element starting with the second element (the first is
        // already sorted)
        for (int i = low; i <= high; i++)
        {
            // loop down to the first element swapping the current
            // element with any other elements that are higher than it
            for (int j = i; j >= low + 1; j--)
            {
                if (array[j] < array[j - 1])
                {
                    swap(array, j, j - 1);
                }
                else
                {
                    // stop now, since all elements to the left are already sorted
                    break;
                }
            }
        }
    }
}
