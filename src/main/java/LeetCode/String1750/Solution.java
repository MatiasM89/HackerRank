package LeetCode.String1750;

public class Solution {
    public int minimumLength(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)) {
            char temp = s.charAt(start);
            while (start <= end && s.charAt(start) == temp)
                start++;
            while (start <= end && s.charAt(end) == temp)
                end--;

        }


        return s.substring(start, end + 1).length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumLength("bbbbbbbbbbbbbbbbbbb"));
    }
}
