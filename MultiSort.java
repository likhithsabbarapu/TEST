import java.util.Arrays;

public class MultiSort {


    //Bubble Sort
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    //Selection Sort
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            //swap
            int temp = arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    //Insertion Sort
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    //Quick sort
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    //Utility method to print the array
    public static void printArray(String type, int arr[]) {
        System.out.println(type + " :" + Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90};
        int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr3 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr4 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr5 = Arrays.copyOf(originalArray, originalArray.length);
        int[] arr6 = Arrays.copyOf(originalArray, originalArray.length);

        bubbleSort(arr1);
        selectionSort(arr2);
        insertionSort(arr3);
        quickSort(arr4, 0, arr4.length - 1);
        printArray("originalArray", originalArray);
        printArray("Bubble sort", arr1);
        printArray("Selection Sort", arr2);
        printArray("Insertion sort", arr3);
        printArray("Quick sort", arr4);
    }

}
