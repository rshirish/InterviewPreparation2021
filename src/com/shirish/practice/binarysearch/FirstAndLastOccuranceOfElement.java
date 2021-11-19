package com.shirish.practice.binarysearch;

public class FirstAndLastOccuranceOfElement {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 4, 4, 8, 9, 10};
        int element = 4;

        int firstIndex = firstOccuranceOfanElement(array, element);
        int lastIndex = lastOccuranceOfAnElement(array, element);
        System.out.println("Result  : " + firstIndex);
        System.out.println("Result  : " + lastIndex);
    }

    private static int lastOccuranceOfAnElement(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println("Mid :   " + mid);
            if (element == array[mid]) {
                index = mid;

                start = mid + 1;
            } else if (element < array[mid]) {
                end = mid - 1;
            } else if (element > array[start]) {
                start = mid + 1;
            }
        }
        return index;
    }

    private static int firstOccuranceOfanElement(int[] array, int element) {
        int start = 0;
        int end = array.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println("Mid :   " + mid);
            if (element == array[mid]) {
                index = mid;
                end = mid - 1;
            } else if (element < array[mid]) {
                end = mid - 1;
            } else if (element > array[start]) {
                start = mid + 1;
            }
        }
        return index;
    }
}
