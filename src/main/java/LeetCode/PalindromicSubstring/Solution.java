package LeetCode.PalindromicSubstring;

//time limit exceeded

public class Solution {
    public String longestPalindrome(String s) {
        String result = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String temp = s.substring(i,j+1);
                if (isPalindrome(temp)) {
                    if (temp.length() > result.length()) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("bb"));


    }

}
