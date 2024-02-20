package LeetCode.MissingNumber268;

import java.util.Arrays;

public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            if (Arrays.binarySearch(nums, i) < 0) {
                return i;
            }
        }
        return 0;
    }
}
