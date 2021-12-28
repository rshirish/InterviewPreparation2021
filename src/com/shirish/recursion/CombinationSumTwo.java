package com.shirish.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
public class CombinationSumTwo {
    public static void main(String args[]) {
        int target = 8;
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSum(candidates, target);
        System.out.println("Result: " + result);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        findCombinationSum(0, target, candidates, result, new ArrayList<Integer>());

        return new ArrayList<>(result);
    }

    private static void findCombinationSum(int index, int target, int[] candidates, Set<List<Integer>> result, ArrayList<Integer> oneResult) {

        if (index == candidates.length) {
            if (target == 0) {
                List<Integer> temp = oneResult.stream().sorted().collect(Collectors.toList());
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        if (candidates[index] <= target) {
            oneResult.add(candidates[index]);
            findCombinationSum(index + 1, target - candidates[index], candidates, result, oneResult);
            oneResult.remove(oneResult.size() - 1);
        }
        findCombinationSum(index + 1, target, candidates, result, oneResult);


    }

}
