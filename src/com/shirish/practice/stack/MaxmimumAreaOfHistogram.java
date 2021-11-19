package com.shirish.practice.stack;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class MaxmimumAreaOfHistogram {

    public static void main(String[] args) {
        int[] input = {6, 2, 5, 4, 5, 1, 6};

        int[] left = getNearestSmallestElementToLeft(input);
        int[] right = getNeareastSmallestElementToRight(input);
        int [] width = new int [input.length];
        for(int i =0; i< input.length; i++)
        {
            width[i] = right[i] - left[i] - 1;
        }

        int[] area = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            area[i] = width[i] * input[i];
        }

        System.out.println("Area" + Arrays.toString(area));

    }

    private static int[] getNearestSmallestElementToLeft(int[] input) {
        int[] result = new int[input.length];
        Stack<Entry> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek().getValue() < input[i]) {
                result[i] = stack.peek().getIndex();
            } else if (stack.size() > 0 && stack.peek().getValue() >= input[i]) {
                while (stack.size() > 0 && stack.peek().getValue() >= input[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek().getIndex();
                }
            }
            stack.push(new Entry(input[i], i));
        }
        return result;
    }

    private static int[] getNeareastSmallestElementToRight(int[] input) {
        int[] result = new int[input.length];
        Stack<Entry> stack = new Stack<>();

        for (int i = input.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek().getValue() < input[i]) {
                result[i] = stack.peek().getIndex();
            } else if (stack.size() > 0 && stack.peek().getValue() >= input[i]) {
                while (stack.size() > 0 && stack.peek().getValue() >= input[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek().getIndex();
                }
            }
            stack.push(new Entry(input[i], i));
        }
        return result;
    }

    private static class Entry {

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int value;

        public int index;

        public Entry(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

}
