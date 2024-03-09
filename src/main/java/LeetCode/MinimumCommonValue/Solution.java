package LeetCode.MinimumCommonValue;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;


public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        SortedSet<Integer> set = new TreeSet<>();

        for (int x : nums1) {
            if (Arrays.binarySearch(nums2, x) >= 0)
                set.add(x);
        }
        for (int x : nums2) {
            if (Arrays.binarySearch(nums1, x) >= 0)
                set.add(x);
        }

        if (!set.isEmpty())
            return set.first();

        return -1;
    }

}
