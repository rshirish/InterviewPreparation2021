package com.shirish.practice.binarysearch;

import java.util.Arrays;

public class FindAElementInRotatedSortedArray {
    public static void main(String[] args) {
        // number of times a sorted array is rotated depends up the index of the minimum element
        // 2 which is smaller thna 18 as well as 3
        int array[] = {15, 18, 2, 3, 6, 12, 13};
        int searchElement = 18;
        //Output: 2
        int rotationCount = getNumberOfTimeASortedArrayIsRotated(array);
        System.out.println("rotationCount " + rotationCount);

        int searchInLeft = binarySearch(Arrays.copyOfRange(array, 0, rotationCount), searchElement);
        int searchInRight = binarySearch(Arrays.copyOfRange(array,  rotationCount, array.length), searchElement);

        System.out.println("searchInLeft " + searchInLeft);
        System.out.println("searchInRight " + searchInRight);


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



    private static int getNumberOfTimeASortedArrayIsRotated(int[] array) {
        int start  = 0;
        int end = array.length-1;
        int count  = 0;

        while(start <= end)
        {
            int mid  = start + ((end-start)/2);
            if(array[mid] <= array[mid -1] && array[mid] <= array[mid+1])
            {
                return mid;
            } else if(array[mid] <= array[start])
            {
                end = mid -1;

            }else if(array[mid] >= array[end]){
                start = mid +1;
            }
        }
        return count;

    }
}
