package com.shirish.practice.binarysearch;

public class SearchInNearlySortedArray {

    public static void main(String[] args) {
        int array[] = {5, 10, 30, 20, 40};
        int element = 20;
        int result = nearlySortedBinarySearch(array, element);
        System.out.println("Result  : " + result);
    }

    private static int nearlySortedBinarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println("Mid :   " + mid);
            if (element == array[mid]) {
                return mid;
            } else if (mid - 1 > start && element == array[mid - 1]) {
                return mid - 1;
            } else if (mid + 1 < end && element == array[mid + 1]) {
                return mid + 1;
            } else if (element < array[mid]) {
                end = mid - 2;
            } else if (element > array[start]) {
                start = mid + 2;
            }

        }
        return index;
    }


}
