package LeetCode.MedianSortedArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//not optimal solution

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> numbers1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> numbers2 = Arrays.stream(nums2).boxed().toList();
        numbers1.addAll(numbers2);
        numbers1.sort(Comparator.naturalOrder());
        if (numbers1.size() % 2 == 0) {
            return (numbers1.get(numbers1.size() / 2) + numbers1.get(numbers1.size() / 2 - 1)) / 2.0;
        }
        return numbers1.get(numbers1.size() / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
