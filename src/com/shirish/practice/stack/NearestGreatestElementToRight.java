package com.shirish.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatestElementToRight {

    public static void main(String[] args) {
        int[] input = {11, 13, 21, 3};
        //13, 21, -1, -1
        System.out.println("The next largest element : " + Arrays.toString(getNearestGreaterElementToRight(input)));
    }

    private static int[] getNearestGreaterElementToRight(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = input.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() > input[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= input[i]) {
                while (stack.size() > 0 && stack.peek() <= input[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(input[i]);
        }
        return result;
    }
}
