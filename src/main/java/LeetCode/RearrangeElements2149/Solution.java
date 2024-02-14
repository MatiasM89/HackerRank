package LeetCode.RearrangeElements2149;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < positive.size(); i++) {
            resultList.add(positive.get(i));
            resultList.add(negative.get(i));
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
