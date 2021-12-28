package com.shirish.recursion;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */
public class SubsetSumTwo {

    public static void main(String args[]) {
        int[] input = new int[]{1, 2, 2};
        List<List<Integer>> result = new ArrayList<>();
        result = subsetsWithDup(input);
        System.out.println("Result : " + result);

    }

    private static List<List<Integer>> subsetsWithDup(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        findSubset(0, input, result, new ArrayList<Integer>());
        return result;
    }

    private static void findSubset(int index, int[] input, List<List<Integer>> result, ArrayList<Integer> oneResult) {
        result.add(new ArrayList<>(oneResult));
        for (int i = index; i < input.length; i++) {
            if (i != index && input[i] == input[i - 1]) continue;
            oneResult.add(input[i]);
            findSubset(i + 1, input, result, oneResult);
            oneResult.remove(oneResult.size() - 1
            );
        }
    }
}
