package com.shirish.practice.binarysearch;

public class FindFloorInSortedArray {

    public static void main(String[] args) {
        int [] array = {1,2 , 4, 8, 10, 10, 12, 19};
        int element = 5;
        int index = binarySearch(array, element);
        System.out.println("Result  : "+index);
        //when moving towards right make sure u store the value for floor
    }

    private static int binarySearch(int[] array, int element) {
        int start = 0;
        int end = array.length-1;
        int floor = -1;
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
                floor = array[mid];
                start = mid +1;
            }

        }
        return floor;
    }

}
