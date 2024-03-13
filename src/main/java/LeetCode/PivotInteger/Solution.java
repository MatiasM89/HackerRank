package LeetCode.PivotInteger;

public class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int index = 0;
        int prefixSum = 0;
        boolean found = false;
        while (index <= n) {
            prefixSum += index;
            if (prefixSum == sum - prefixSum + index) {
                found = true;
                break;

            }
            index++;
        }
        if (!found)
            return -1;
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 8;
        System.out.println(solution.pivotInteger(n));
    }
}
