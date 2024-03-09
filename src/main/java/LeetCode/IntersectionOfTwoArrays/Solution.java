package LeetCode.IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> list = new HashSet<>();
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        for (int x : nums1) {
            if (list2.contains(x))
                list.add(x);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
