package LeetCode.ContiguousArray;

import java.util.HashMap;

public class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0, -1);    ///////////!!!!! bot zauwazyl te linijke
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                if (i - map.get(sum) > max) {
                    max = i - map.get(sum);
                }
            }
        }
        if (sum == 0) {
            return nums.length;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 1};
        System.out.println(s.findMaxLength(nums));
    }
}
