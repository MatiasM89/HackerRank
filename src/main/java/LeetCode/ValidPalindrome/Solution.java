package LeetCode.ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(Character.isLetterOrDigit(temp)){
                builder.append(Character.toLowerCase(temp));
            }
        }
        String normal = builder.toString();
        String reversed = builder.reverse().toString();

        return normal.equals(reversed);
    }
}
