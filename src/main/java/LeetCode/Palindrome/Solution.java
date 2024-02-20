package LeetCode.Palindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String text = String.valueOf(x);
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
