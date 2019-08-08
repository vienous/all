package question.sort;

import java.util.Arrays;

public class QuickSort {

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        // 得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        // 用分治法递归数列的两部分
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        while (startIndex < endIndex) {
            while (arr[startIndex] <= pivot && startIndex < endIndex) {
                startIndex++;
            }
            if (startIndex < endIndex) {
                swap(arr, startIndex, endIndex);
                endIndex--;
            }
            while (arr[endIndex] >= pivot && startIndex < endIndex) {
                endIndex--;
            }
            if (startIndex < endIndex) {
                swap(arr, startIndex, endIndex);
                startIndex++;
            }
        }
        return endIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
