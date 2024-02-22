package LeetCode.LongestCommonPrefix;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder prefix = new StringBuilder();
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == last.charAt(i)) {
                prefix.append(first.charAt(i));
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = {"a"};
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
