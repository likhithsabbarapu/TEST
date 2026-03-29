import java.util.*;

public class AdvancedSort {

    // 🔹 Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    // 🔹 Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // 🔹 Counting Sort
    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];

        for (int num : arr) count[num]++;

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    // 🔹 Radix Sort
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    // 🔹 Utility
    public static void printArray(String name, int[] arr) {
        System.out.println(name + ": " + Arrays.toString(arr));
    }

    public static int[] cloneArray(int[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) {

        int[] original = {170, 45, 75, 90, 802, 24, 2, 66};

        int[] arr1 = cloneArray(original);
        int[] arr2 = cloneArray(original);
        int[] arr3 = cloneArray(original);
        int[] arr4 = cloneArray(original);
        int[] arr5 = cloneArray(original);
        int[] arr6 = cloneArray(original);

        mergeSort(arr1, 0, arr1.length - 1);
        heapSort(arr2);
        countingSort(arr3);
        radixSort(arr4);

        Arrays.sort(arr5); // Inbuilt
        Arrays.parallelSort(arr6); // Parallel

        printArray("Merge Sort", arr1);
        printArray("Heap Sort", arr2);
        printArray("Counting Sort", arr3);
        printArray("Radix Sort", arr4);
        printArray("Inbuilt Sort", arr5);
        printArray("Parallel Sort", arr6);
    }
}