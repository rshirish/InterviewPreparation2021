package com.shirish.practice.binarysearch;

import java.util.Arrays;

public class IndexOfFirstOneInBinarySortedArray {

    public static void main(String[] args) {
        int [] array = {0,0,0,0,0,0,1,1,1,1,1,1};
        int element = 1;

        ////////////////////

        int high = 1;
        while(element > array[high])
        {

            high = high *2;

        }

        int index = BinarySearch(Arrays.copyOfRange(array, 0, high), element);
        System.out.println("Result  : "+index);


    }

    private static int BinarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length -1;
        int result = -1;
        while(start <= end)
        {
            int mid  = start + ( (end-start)/2);
            if(element == array[mid])
            {
                result = mid;
                end = mid-1;
            }
            else if(element  < array[mid])
            {
                end = mid-1;
            } else
            {
                start = mid+1;
            }
        }

        return result;
    }

}

