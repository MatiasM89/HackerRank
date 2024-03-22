package LeetCode.ValidPalindrome2;

public class Solution {
    public boolean validPalindrome(String s) {
        if (isPalindrome(s))
            return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(s.substring(start + 1, end + 1)) || isPalindrome(s.substring(start, end));
    }

    private boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder(s);

        return s.equals(builder.reverse().toString());
    }
}
