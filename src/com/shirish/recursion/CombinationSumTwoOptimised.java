package com.shirish.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

        Each number in candidates may only be used once in the combination.

        Note: The solution set must not contain duplicate combinations.



        Example 1:

        Input: candidates = [10,1,2,7,6,1,5], target = 8
        Output:
        [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]
        Example 2:

        Input: candidates = [2,5,2,1,2], target = 5
        Output:
        [
        [1,2,2],
        [5]
        ]


        Constraints:

        1 <= candidates.length <= 100
        1 <= candidates[i] <= 50
        1 <= target <= 30

*/
public class CombinationSumTwoOptimised {

    public static void main(String args[]) {
        int target = 8;
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>>
        result = combinationSum(candidates, target);
        System.out.println("Result: " + result);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumCalulate(0, candidates, target, result, new ArrayList<>());
        return result;


    }

    private static void combinationSumCalulate(int index, int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> oneResult) {

        if (target == 0) {
            result.add(new ArrayList<Integer>(oneResult));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target) break;

            oneResult.add(candidates[i]);
            combinationSumCalulate(i + 1, candidates, target - candidates[i], result, oneResult);
            oneResult.remove(oneResult.size() - 1);

        }


    }

}
