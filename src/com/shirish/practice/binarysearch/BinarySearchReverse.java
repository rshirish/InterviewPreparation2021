package com.shirish.practice.binarysearch;

public class BinarySearchReverse {

    public static void main(String[] args) {
        int [] array = {10,9,8,7,6,5,4,3,2,1};
        int element = 7;

        int index = binarySearchReverse(array, element);
        System.out.println("Result  : "+index);
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
