package LeetCode.CountSubarraysWithMaxElement;

import java.util.Arrays;

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long counter = 0;
        int currentNumberOfMax = 0;
        //doing the reverse problem
        //amount of subarrays where max element appears less than K times

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == max)
                currentNumberOfMax++;
            while (currentNumberOfMax >= k) {
                if (nums[left] == max)
                    currentNumberOfMax--;
                left++;
            }
            counter = counter + 1 + (right - left);
        }

        return ((long) nums.length * (nums.length + 1)) / 2 - counter;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }
}
