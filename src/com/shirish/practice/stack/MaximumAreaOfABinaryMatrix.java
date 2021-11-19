package com.shirish.practice.stack;

public class MaximumAreaOfABinaryMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
        int [] input  = new int[matrix[0].length];
        int max;
        for(int i =0 ; i < matrix[0].length; i++)
        {
            input[i] = matrix[0][i];
        }
        max  = MAH(input);
        for(int i = 1; i<matrix.length; i++)
        {
            for(int j =0 ; j< matrix[i].length; i++)
            {
                if(matrix[i][j]==0)
                {
                    input[j] =0;
                } else{
                    input[j] = input[j] + matrix[i][j];
                }
            }
            max= Math.max(max, MAH(input));
        }

}

    private static int MAH(int[] input) {
        return 0;
    }
    }
