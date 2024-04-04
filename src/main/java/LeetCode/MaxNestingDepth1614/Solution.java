package LeetCode.MaxNestingDepth1614;

public class Solution {
    public int maxDepth(String s) {
        int counter = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
            }
            if (s.charAt(i) == ')') {
                max = Math.max(max, counter);
                counter--;
            }
        }
        return max;
    }
}
