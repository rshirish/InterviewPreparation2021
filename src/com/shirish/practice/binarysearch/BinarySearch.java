package com.shirish.practice.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int [] array = {1, 2, 3, 4,5, 6, 7, 8, 9, 10};
        int element = 7;

        int index = binarySearch(array, element);
        System.out.println("Result  : "+index);


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

}
