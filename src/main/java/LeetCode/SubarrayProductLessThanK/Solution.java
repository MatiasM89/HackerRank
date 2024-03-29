package LeetCode.SubarrayProductLessThanK;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int counter = 0;
        int product = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            counter = counter + 1 + (right - left);
        }

        return counter;
    }
}
