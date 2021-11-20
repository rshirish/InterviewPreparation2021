package com.shirish.practice.binarysearch;

import java.util.Arrays;

public class SearchInBitonicArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] array = {5, 10, 20, 15};
        int element= 10;
        //find peak element;
        int peakIndex = findPeak(array);
        System.out.println("Peak  : "+peakIndex);



        int indexLeft = binarySearch(Arrays.copyOfRange(array, 0, peakIndex), element);
        System.out.println("Result indexLeft  : "+indexLeft);
        int indexRight = binarySearchReverse(Arrays.copyOfRange(array, peakIndex, array.length), element);
        System.out.println("Result indexRight  : "+indexRight);


    }

    private static int findPeak(int[] array) {
        int start = 0;
        int end = array.length-1;
        int index = -1;
        while (start<=end)
        {
            int mid  = start + ((end-start)/2);

            if(mid > 0 && mid < array.length-1) {
                System.out.println("Mid :   " + mid);
                if (array[mid-1] < array[mid] && array[mid+1] < array[mid]) {
                    return mid;
                } else if (array[mid-1] > array[mid]) {
                    end = mid - 1;
                } else if (array[mid+1] > array[mid]) {
                    start = mid + 1;
                }
            }
            else if(mid == 0)
            {
                return mid;
            } else if (mid == array.length-1)
            {
                return mid;
            }

        }
        return index;
    }

    private static int binarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length-1;
        int index = -1;
        while (start<=end)
        {
            int mid  = start + ((end-start)/2);
            System.out.println("Mid :   "+mid);
            if(element == array[mid])
            {
                return mid;
            } else if (element < array[mid])
            {
                end = mid -1;
            } else if(element > array[start])
            {
                start = mid +1;
            }

        }
        return index;
    }


    private static int binarySearchReverse(int[] array, int element) {
        int start = 0;
        int end = array.length-1;
        int index = -1;
        while (start<=end)
        {
            int mid  = start + ((end-start)/2);
            System.out.println("Mid :   "+mid);
            if(element == array[mid])
            {
                return mid;
            } else if (element < array[mid])
            {
                start = mid +1;
            } else
            {
                end = mid -1;
            }

        }
        return index;

    }
}
