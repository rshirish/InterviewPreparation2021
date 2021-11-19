package com.shirish.practice.stack;

import java.util.Arrays;

public class RainWaterTapping {

    public static void main(String[] args) {
        //int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] arr = { 3, 0, 0, 2, 0 , 4 };
        //OP - 10
        int n = arr.length;

        System.out.print(maxWater(arr,n));

    }

    private static int maxWater(int[] input, int size) {
        int [] maxLeft = new int [size];
        int [] maxRight = new int [size];

        maxLeft[0] = input[0];
        for(int i =1; i< size ; i++)
        {
            maxLeft[i] = Math.max(maxLeft[i-1], input[i]);
        }

        maxRight[size -1] = input[size -1];
        for(int i =size - 2; i >= 0 ; i--)
        {
            maxRight[i] = Math.max(maxRight[i+1], input[i]);
        }

        int [] water = new int [size];
        for(int i = 0; i< size ; i++)
        {
            water[i] = Math.min(maxRight[i], maxLeft[i]) - input[i];
        }
        int sum =0;
        for(int i = 0; i< size ; i++)
        {
            sum = sum + water[i];
        }

  return sum;
    }
}
