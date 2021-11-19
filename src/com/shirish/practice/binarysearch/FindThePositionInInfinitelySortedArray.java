package com.shirish.practice.binarysearch;

import java.util.Arrays;

public class FindThePositionInInfinitelySortedArray {
    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4,5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int element = 7;

        ////////////////////

        int high = 1;
        while(element > array[high]) // negative condition
        {

            high = high *2;

        }
        //Arrays.copyOfRange(array, 0, high)
        int index = BinarySearch(Arrays.copyOfRange(array, 0, high), element);
        System.out.println("Result  : "+index);


    }

    private static int BinarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length -1;
        while(start <= end)
        {
            int mid  = start + ( (end-start)/2);
            if(element == array[mid])
            {
                return mid;
            }
            else if(element  < array[mid])
            {
                end = mid-1;
            } else
            {
                start = mid+1;
            }
        }

        return -1;
    }
}
