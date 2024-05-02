package divide_and_conquer;

public class MergeSort {
    private static int[] temp;

    public static void mergeSort(int[] array)
    {
        if (array.length == 0 || array.length == 1)
        {
            return; // already sorted
        }

        temp = new int[array.length];

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(
            int[] array, int low, int high)
    {
        if (high - low == 0)
        {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        merge(array, low, high);
    }

    private static void merge(int[] array, int low, int high)
    {
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;
        int count = high - low + 1;

        for (int i = 0; i < count; i++)
        {
            if (left > mid)
                temp[low + i] = array[right++];
            else if (right > high)
                temp[low + i] = array[left++];
            else if (array[left] < array[right])
                temp[low + i] = array[left++];
            else if (array[left] >= array[right])
                temp[low + i] = array[right++];
        }

        for (int i = 0; i < count; i++)
        {
            array[low + i] = temp[low + i];
        }
    }
}
