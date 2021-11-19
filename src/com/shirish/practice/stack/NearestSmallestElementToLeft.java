package com.shirish.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestElementToLeft {
    public static void main(String[] args) {
        int[] input = { 4, 5, 2, 10,8 };
        //-1 4 -1 2 2
        System.out.println("NearestSmallestElementToLeft " + Arrays.toString(getNearestSmallestElementToLeft(input)));
    }

    private static int[] getNearestSmallestElementToLeft(int[] input) {
        int[] result = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek() < input[i]) {
                result[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() >= input[i]) {
                while (stack.size() > 0 && stack.peek() >= input[i]) {
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
