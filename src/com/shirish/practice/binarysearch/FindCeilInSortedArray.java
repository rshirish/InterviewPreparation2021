package com.shirish.practice.binarysearch;

public class FindCeilInSortedArray {
    public static void main(String[] args) {
        int [] array = {1,2 , 4, 8, 10, 10, 12, 19};
        int element = 5;
        int index = binarySearch(array, element);
        System.out.println("Result  : "+index);
        //when moving towards left make sure u store the value for ceil

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
                index = array[mid];
                end = mid -1;
            } else if(element > array[start])
            {
                start = mid +1;
            }

        }
        return index;
    }
}
