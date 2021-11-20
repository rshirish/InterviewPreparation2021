package com.shirish.practice.binarysearch;

public class PeakElementInAnUnsortedArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int [] array = {5, 10, 20, 15};
        //find peak element;
        int index = binarySearch(array);
        System.out.println("Result  : "+index);


    }
    private static int binarySearch(int[] array) {
        int start = 0;
        int end = array.length-1;
        int index = -1;
        while (start<=end)
        {
            int mid  = start + ((end-start)/2);

            if(mid > 0 && mid < array.length-1) {
                System.out.println("Mid :   " + mid);
                if (array[mid-1] < array[mid] && array[mid+1] < array[mid]) {
                    return array[mid];
                } else if (array[mid-1] > array[mid]) {
                    end = mid - 1;
                } else if (array[mid+1] > array[mid]) {
                    start = mid + 1;
                }
            }
            else if(mid == 0)
            {
                return array[0];
            } else if (mid == array.length-1)
            {
                return array[array.length-1];
            }

        }
        return index;
    }



}
