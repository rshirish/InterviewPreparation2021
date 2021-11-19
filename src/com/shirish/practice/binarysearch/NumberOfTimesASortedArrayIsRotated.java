package com.shirish.practice.binarysearch;

public class NumberOfTimesASortedArrayIsRotated {
    public static void main(String[] args) {
        // number of times a sorted array is rotated depends up the index of the minimum element
        // 2 which is smaller thna 18 as well as 3
        //int array[] = {15, 18, 2, 3, 6, 12,13};
        //jaha disturbancy go to that side

        int array[] = { 6, 12, 13, 15 , 18, 2, 3};

        //	int array[] = {3, 4,2, 5, 1};
        //{1, 2, 3, 4, 5}
        //Output: 2
        int rotationCount  = getNumberOfTimeASortedArrayIsRotated(array);
        System.out.println("rotationCount " +rotationCount);

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
