package com.shirish.recursion;

/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String args[])
    {
        List<List<String>> result  = new ArrayList<>();
        String input = "aab";
        result  = partition(input);
        System.out.println("Result : "+result);


    }

    private static List<List<String>> partition(String input) {
        List<List<String>> result  = new ArrayList<>();
        palindromePartitioning(0, input, result, new ArrayList<>());
        return result;

    }

    private static void palindromePartitioning(int index, String input, List<List<String>> result, ArrayList<String> oneResult) {
        if(index == input.length())
        {
            result.add(new ArrayList<>(oneResult));
            return;
        }

        for(int i = index; i< input.length(); i++)
        {
            if(isPalindrome(index , i , input))
            {
                oneResult.add(input.substring(index, i+1));
                palindromePartitioning(i+1, input, result, oneResult);
                oneResult.remove(oneResult.size()-1);
            }
        }
    }

    private static boolean isPalindrome(int start, int end, String input) {
        while(start <= end)
        {
            if(input.charAt(start++) != input.charAt(end--))
            {
                 return false;
            }
        }
        return true;
    }
}
