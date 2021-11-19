package com.shirish.practice.binarysearch;

public class NextAlphabeticalElement {
    public static void main(String[] args) {
        //LeetCode
        // TODO Auto-generated method stub
        char [] array = {'a','c', 'f', 'h'};
        char element = 'd';
        char index = (char) binarySearch(array, element);
        System.out.println("Result  : "+index);


    }

    private static char binarySearch(char[] array, int element) {
        int start = 0;
        int end = array.length-1;
        char index = '#';
        while (start<=end)
        {
            int mid  = start + ((end-start)/2);
            System.out.println("Mid :   "+mid);
            if(element == array[mid])
            {
                return array[mid];
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
