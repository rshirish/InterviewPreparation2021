package com.shirish.practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
    /*The stock span problem is a financial problem where we have a series of n daily price quotes for a
     stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number
 of consecutive days just before the given day, for which the price of the stock on the current
 day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
*/

    public static void main(String[] args) {
        //0   1   2   3   4   5   6
        int[] input = {100, 80, 60, 70, 60, 75, 85};
        //{1, 1, 1, 2, 1, 4, 6}
        System.out.println("NearestGreaterElementToTheLeft: " + Arrays.toString(getStockSpan(input)));
    }

    private static int[] getStockSpan(int[] input) {
        Stack<Entry> stack = new Stack<Entry>();
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if (stack.size() == 0) {
                result[i] = -1;
            } else if (stack.size() > 0 && stack.peek().getValue() > input[i]) {
                result[i] = stack.peek().getIndex();

            } else if (stack.size() > 0 && stack.peek().getValue() <= input[i]) {
                while (stack.size() > 0 && stack.peek().getValue() <= input[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek().getIndex();
                }
            }
            stack.add(new StockSpanProblem.Entry(input[i], i));

        }
        int[] span = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            span[i] = i - result[i];
        }
        return span;
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
