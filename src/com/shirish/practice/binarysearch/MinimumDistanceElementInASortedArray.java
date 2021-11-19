package com.shirish.practice.binarysearch;

public class MinimumDistanceElementInASortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] array = {1, 3, 8, 10, 12, 15};
        int element = 13;
        int minimumDifferenceElement = binarySearch(array, element);
        System.out.println("Result  : "+minimumDifferenceElement);
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
                return array[mid];
            } else if (element < array[mid])
            {
                end = mid -1;
            } else if(element > array[start])
            {
                start = mid +1;
            }

        }
        int low = Math.abs(element - array[start]);
        int high = Math.abs(element - array[end]);
        index = (high > low) ? array[start] : array[end];
        return index;
    }
}
