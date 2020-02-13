package Sorting;

public class Quicksort {
    //Wost - Time O(n^2) | Space O(log(n))
    //best - Time O(nLog(n)) | Space O(log(n))
    //average - Time O(nLog(n)) | Space O(log(n))
    public static int[] quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
        return array;
    }

    public static void quickSortHelper(int[] array, int left, int right){
        if (left < right){
            int pivot = partition(array, left, right);
            quickSortHelper(array, left, pivot-1);
            quickSortHelper(array, pivot+1, right);
        }
    }

    public static int partition(int[] array, int left, int right){
        int i = left-1;
        int j = left;
        while(j < right){
            if(array[j] <= array[right]){
                int temp = array[i+1];
                array[i+1] = array[j];
                array[j] = temp;
                i++;
            }
            j++;
        }
        int temp = array[i+1];
        array[i+1] = array[j];
        array[j] = temp;
        return i+1;
    }
}