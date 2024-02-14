package LeetCode.ReverseInteger;

public class Solution {
    public int reverse(int x) {
        StringBuilder builder = new StringBuilder();
        boolean isNeg = false;
        builder.append(x);
        builder.reverse();
        if (x < 0) {
            builder.deleteCharAt(builder.length() - 1);
            isNeg = true;
        }
        try {
            x = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if (isNeg) {
            return (-1) * x;
        }
        return x;
    }
}
